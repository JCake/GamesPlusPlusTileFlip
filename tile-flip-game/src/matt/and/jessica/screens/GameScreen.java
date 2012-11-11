package matt.and.jessica.screens;

import java.util.List;

import matt.and.jessica.Grid;
import matt.and.jessica.Puzzle;
import matt.and.jessica.Tile;
import matt.and.jessica.renderers.ClueRenderer;
import matt.and.jessica.renderers.GridRenderer;
import matt.and.jessica.renderers.MovesRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;

public class GameScreen implements Screen, InputProcessor{

	GridRenderer gridRenderer;
	ClueRenderer clueRenderer;
	MovesRenderer movesRenderer;
	private Grid grid;
	private int puzzleNumber = 0;
	private final List<Puzzle> puzzles;
	private int screenHeight;
	private int screenWidth;
	private Preferences prefs;
	private Sound victorySound;
	private Sound moveSound;
	
	public GameScreen(List<Puzzle> puzzles, int width, int height){
		this.puzzles = puzzles;
		this.puzzleNumber = 0;
		this.solvedPuzzle = false;
		this.screenHeight = width;
		this.screenHeight = height;
		prefs = Gdx.app.getPreferences("scores");
		checkBestScore();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float arg0) {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); // This cryptic line clears the screen. - thanks StackOverflow!
		gridRenderer.render();
		clueRenderer.render();
		movesRenderer.render();
//		bestScoreRenderer.render();
	}

	private void checkBestScore() {
		int bestScore = getBestScore();
		System.out.println("Best score: " + bestScore);
		if (bestScore <= 0) {
			setBestScore(999999);
		}
	}
	
	@Override
	public void resize(int width, int height) {
		this.screenHeight = height;
		this.screenWidth = width;
		movesRenderer.resize(width, height);
		gridRenderer.resize(width, height);
		clueRenderer.resize(width, height);
	}

	private void setBestScore(int score) {
		prefs.putInteger("bestscore", score);
		prefs.flush();
		movesRenderer.updateBest(score);
	}

	private int getBestScore() {
		int bestScore = prefs.getInteger("bestscore");
		return bestScore;
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		movesRenderer = new MovesRenderer(getBestScore());
		Puzzle puzzle = puzzles.get(puzzleNumber);
		grid = new Grid(puzzle.initialState);
		gridRenderer = new GridRenderer(grid);
		gridRenderer.setSolutionOutline(null);
		if(puzzle.outlineSolution){
			gridRenderer.setSolutionOutline(puzzle.solvedState);
		}
		clueRenderer = new ClueRenderer(puzzle.clue);
		Gdx.input.setInputProcessor(this);
		
		victorySound = Gdx.audio.newSound(Gdx.files.internal("win1.ogg"));
		moveSound = Gdx.audio.newSound(Gdx.files.internal("mouthpop.wav"));
	}

	@Override
	public boolean keyDown(int arg0) {
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	private int startingX;
	private int startingY;
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		startingX = screenX;
		startingY = screenY;
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int arg2) {
		updateSelections(screenX, screenY);
		return true;
	}
	
	private int adjustWithinBounds(int min, int max, int value){
		return Math.min(max, Math.max(min, value));
	}

	private void updateSelections(int screenX, int screenY) {
		grid.clearSelection();
		int startXIndex = adjustWithinBounds(0,grid.getWidth()-1,findXIndexInGrid(startingX));
		int startYIndex = adjustWithinBounds(0,grid.getHeight()-1,findYIndexInGrid(startingY));
		int endXIndex = adjustWithinBounds(0,grid.getWidth()-1,findXIndexInGrid(screenX));
		int endYIndex = adjustWithinBounds(0,grid.getHeight()-1,findYIndexInGrid(screenY));
		if(endXIndex == startXIndex){
			int lowerY = Math.min(startYIndex, endYIndex);
			int upperY = Math.max(startYIndex, endYIndex);
			for(int y = lowerY; y <= upperY; y++){
				grid.tiles[endXIndex][y].isSelected = true;
			}
		}
		else if(endYIndex == startYIndex){
			int lowerX = Math.min(startXIndex, endXIndex);
			int upperX = Math.max(startXIndex, endXIndex);
			for(int x = lowerX; x <= upperX; x++){
				grid.tiles[x][endYIndex].isSelected = true;
			}
		}else{
			int lowerX = Math.min(startXIndex, endXIndex);
			int lowerY = Math.min(startYIndex, endYIndex);
			int upperY = Math.max(startYIndex, endYIndex);
			int upperX = Math.max(startXIndex, endXIndex);
			if(upperX-lowerX == upperY-lowerY){
				for(int i = 0; i <= upperX-lowerX; i++){
					if(lowerX == startXIndex && lowerY == startYIndex){
						grid.tiles[lowerX+i][lowerY+i].isSelected = true;
					}else if(lowerX == startXIndex && lowerY == endYIndex){
						grid.tiles[lowerX+i][upperY-i].isSelected = true;
					}else if(lowerX == endXIndex && lowerY == startYIndex){
						grid.tiles[upperX-i][lowerY+i].isSelected = true;
					}else{
						grid.tiles[upperX-i][upperY-i].isSelected = true;
					}
				}
			}
		}
	}
	
	boolean readyToMove = false;
	Tile tileToMove;
	boolean solvedPuzzle = false;
	boolean readyToRestart = false;
	
	@Override
	public boolean touchUp(int screenX, int screenY, int arg2, int arg3) {
		
		if(solvedPuzzle){ //Advance to next level
			solvedPuzzle = false;
			if(puzzleNumber < puzzles.size() - 1){
				Puzzle puzzle = puzzles.get(++puzzleNumber);
				Grid nextStartingState = puzzle.initialState;
				grid = new Grid(nextStartingState);
				gridRenderer.setGrid(grid);
				gridRenderer.setSolutionOutline(null);
				if(puzzle.outlineSolution){
					gridRenderer.setSolutionOutline(puzzle.solvedState);
				}
				clueRenderer.setClue(puzzle.clue);
				Gdx.input.setInputProcessor(this);
				return true;
			}else{
				int moves = movesRenderer.moves;
				if (moves < getBestScore()) {
					clueRenderer.setClue("NEW BEST SCORE!");
					setBestScore(moves);
//				}else if(readyToRestart){ //restart the game
//					readyToRestart = false;
//					puzzleNumber = 0;
//					show();
				}else {
					clueRenderer.setClue("You got 'em all!");
					readyToRestart = true;
				}
				return false; //No more puzzles
			}
		}
		
		updateSelections(screenX, screenY);
		for(int x = 0; x < grid.getWidth(); x++){
			for(int y = 0; y < grid.getHeight(); y++){
				if(grid.tiles[x][y].isSelected){
					grid.tiles[x][y].isDarkened = !grid.tiles[x][y].isDarkened;
					grid.tiles[x][y].isSelected = false;
				}
			}
		}
		moveSound.play();
		movesRenderer.moves++;
		
		if(puzzleSolved()){
			//Puzzle has been solved
			System.out.println("You win!");
			clueRenderer.setClue("YOU GOT IT!");
	        victorySound.play();
			solvedPuzzle = true;
		}
		return true;
	}

	private int findYIndexInGrid(int screenY) {
		return (screenHeight - screenY - gridRenderer.getGridRenderedY()) / (gridRenderer.getHeight()/grid.tiles[0].length);
	}

	private int findXIndexInGrid(int screenX) {
		return (screenX - gridRenderer.getGridRenderedX()) / (gridRenderer.getWidth()/grid.tiles.length);
	}

	private boolean puzzleSolved() {
		boolean solved = true;
		for(int x = 0; x < grid.getWidth(); x++){
			for(int y = 0; y < grid.getHeight(); y++){
				if(grid.tiles[x][y].isDarkened != puzzles.get(puzzleNumber).solvedState.tiles[x][y].isDarkened){
					solved = false;
				}
			}
		}
		return solved;
	}
}
