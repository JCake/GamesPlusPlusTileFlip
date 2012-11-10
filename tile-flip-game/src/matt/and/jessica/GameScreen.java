package matt.and.jessica;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

public class GameScreen implements Screen, InputProcessor{

	GridRenderer gridRenderer;
	ClueRenderer clueRenderer;
	private Grid grid;
	private int puzzleNumber = 0;
	private final List<Puzzle> puzzles;
	
	public GameScreen(List<Puzzle> puzzles){
		this.puzzles = puzzles;
		this.puzzleNumber = 0;
		this.solvedPuzzle = false;
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
		gridRenderer.render();
		clueRenderer.render();
	}
	
	private int screenHeight;
	private int screenWidth;
	
	@Override
	public void resize(int width, int height) {
		this.screenHeight = height;
		this.screenWidth = width;
		gridRenderer.resize(width, height);
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		grid = new Grid(puzzles.get(puzzleNumber).initialState);
		gridRenderer = new GridRenderer(grid );
		clueRenderer = new ClueRenderer(puzzles.get(puzzleNumber).clue);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public boolean keyDown(int arg0) {
		System.out.println("key pressed");
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

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}
	
	boolean readyToMove = false;
	Tile tileToMove;
	boolean solvedPuzzle = false;
	
	@Override
	public boolean touchUp(int screenX, int screenY, int arg2, int arg3) {
		
		if(solvedPuzzle){ //Advance to next level
			if(puzzleNumber < puzzles.size() - 1){
				Puzzle puzzle = puzzles.get(++puzzleNumber);
				Grid nextStartingState = puzzle.initialState;
				grid = new Grid(nextStartingState);
				gridRenderer.setGrid(grid);
				clueRenderer.setClue(puzzle.clue);
				solvedPuzzle = false;
				Gdx.input.setInputProcessor(this);
				return true;
			}else{
				return false; //No more puzzles
			}
		}
		int xIndex = findXIndexInGrid(screenX);
		int yIndex = findYIndexInGrid(screenY);
		
		if(xIndex >= grid.getWidth() || yIndex >= grid.getHeight() || xIndex < 0 || yIndex < 0){
			return false;
		}
		System.out.println("Clicked tile: " + xIndex + "," + yIndex);
		
		if(!readyToMove){
			readyToMove = true;
			tileToMove = grid.tiles[xIndex][yIndex];
			tileToMove.isSelected = true;
		}else{
			readyToMove = false;
			tileToMove.isSelected = false;
			if(Math.abs(xIndex - tileToMove.getX()) <= 1 && Math.abs(yIndex - tileToMove.getY()) <= 1){
				Tile moveTo = grid.tiles[xIndex][yIndex];
				boolean moveToDarkened = moveTo.isDarkened;
				boolean moveFromDarkened = tileToMove.isDarkened;
				moveTo.isDarkened = moveFromDarkened;
				tileToMove.isDarkened = moveToDarkened;
			}
		}
		
		if(puzzleSolved()){
			//Puzzle has been solved
			System.out.println("You win!");
			grid.displayWin();
			solvedPuzzle = true;
		}
		return true;
	}

	private int findYIndexInGrid(int screenY) {
		return (screenHeight - screenY - gridRenderer.gridRenderedY) / (gridRenderer.getHeight()/grid.tiles[0].length);
	}

	private int findXIndexInGrid(int screenX) {
		return (screenX - gridRenderer.gridRenderedX) / (gridRenderer.getWidth()/grid.tiles.length);
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
