package matt.and.jessica;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Game;

public class TileFlipGame  extends Game {

	@Override
	public void create() {
		List<Puzzle> puzzles = new ArrayList<Puzzle>();
		int size = 3;
		
		addFirstPuzzle(puzzles, size);
		addSecondPuzzle(puzzles, size);
		
		setScreen(new GameScreen(puzzles));
		
	}

	private void addFirstPuzzle(List<Puzzle> puzzles, int size) {
		Puzzle firstPuzzle = new Puzzle();
		firstPuzzle.clue = "CLUE 1";
		firstPuzzle.initialState = new Grid(size,size);
		for(int i = 0; i < size; i++){
			firstPuzzle.initialState.turnOnTile(i, i);
		}
		firstPuzzle.solvedState = new Grid(size,size);
		for(int i = 0; i < size; i++){
			firstPuzzle.solvedState.turnOnTile(0, i);
		}
		puzzles.add(firstPuzzle );
	}

	private void addSecondPuzzle(List<Puzzle> puzzles, int size) {
		Puzzle secondPuzzle = new Puzzle();
		secondPuzzle.clue = "CLUE 2";
		secondPuzzle.initialState = new Grid(size,size);
		for(int i = 0; i < size; i++){
			secondPuzzle.initialState.turnOnTile(i, size - 1 - i);
		}
		secondPuzzle.solvedState = new Grid(size,size);
		for(int i = 0; i < size; i++){
			secondPuzzle.solvedState.turnOnTile(size - 1, i);
		}
		puzzles.add(secondPuzzle);
	}

}
