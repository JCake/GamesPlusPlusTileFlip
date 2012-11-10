package matt.and.jessica;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen, InputProcessor{

	GridRenderer renderer;
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
		renderer.render();
	}
	
	int width = 300;
	int height = 300;

	@Override
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
		renderer.resize(width, height);
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		grid = new Grid(puzzles.get(puzzleNumber).initialState);
		renderer = new GridRenderer(grid );
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
			Grid nextStartingState = puzzles.get(++puzzleNumber).initialState;
			grid = new Grid(nextStartingState);
			renderer.setGrid(grid);
			solvedPuzzle = false;
			Gdx.input.setInputProcessor(this);
			return true;
			//TODO handle puzzle Number too big
		}
		int xIndex = screenX / (width/grid.tiles.length);
		int yIndex = (height - screenY) / (height/grid.tiles[0].length);
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
