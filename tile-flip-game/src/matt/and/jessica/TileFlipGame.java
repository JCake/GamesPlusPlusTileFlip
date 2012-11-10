package matt.and.jessica;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Game;

public class TileFlipGame  extends Game {

	@Override
	public void create() {
		List<Puzzle> puzzles = new ArrayList<Puzzle>();
		int size = 4;
		
		addFirstPuzzle(puzzles, size);
		addSecondPuzzle(puzzles, size);
		addThirdPuzzle(puzzles);
		addFourthPuzzle(puzzles);
		
		setScreen(new GameScreen(puzzles));
		
	}

	private void addFirstPuzzle(List<Puzzle> puzzles, int size) {
		Puzzle firstPuzzle = new Puzzle();
		firstPuzzle.clue = "Don't be a ____";
		firstPuzzle.initialState = new Grid(size,size);
		for(int i = 0; i < size; i++){
			firstPuzzle.initialState.turnOnTile(i, i);
		}
		firstPuzzle.solvedState = new Grid(size,size);
		firstPuzzle.solvedState.turnOnTile(1, 1);
		firstPuzzle.solvedState.turnOnTile(1, 2);
		firstPuzzle.solvedState.turnOnTile(2, 1);
		firstPuzzle.solvedState.turnOnTile(2, 2);
		puzzles.add(firstPuzzle );
	}

	private void addSecondPuzzle(List<Puzzle> puzzles, int size) {
		Puzzle secondPuzzle = new Puzzle();
		secondPuzzle.clue = "Fore!";
		secondPuzzle.initialState = new Grid(size,size);
		secondPuzzle.initialState.turnOnTile(0, 0);
		secondPuzzle.initialState.turnOnTile(1, 1);
		secondPuzzle.initialState.turnOnTile(2, 2);
		secondPuzzle.initialState.turnOnTile(1, 2);
		secondPuzzle.initialState.turnOnTile(2, 1);
		secondPuzzle.solvedState = new Grid(size,size);
		secondPuzzle.solvedState.turnOnTile(1, 0);
		secondPuzzle.solvedState.turnOnTile(2, 0);
		secondPuzzle.solvedState.turnOnTile(2, 1);
		secondPuzzle.solvedState.turnOnTile(2, 2);
		secondPuzzle.solvedState.turnOnTile(2, 3);
		puzzles.add(secondPuzzle);
	}
	
	private void addThirdPuzzle(List<Puzzle> puzzles) {
		int size = 5;
		Puzzle puzzle = new Puzzle();
		
		puzzle.clue = "Me, myself";
		
		puzzle.initialState = new Grid(size,size);
		puzzle.initialState.turnOnTile(0, 0);
		puzzle.initialState.turnOnTile(0, size-1);
		puzzle.initialState.turnOnTile(size-1, 0);
		puzzle.initialState.turnOnTile(size-1, size-1);
		
		puzzle.solvedState = new Grid(size,size);
		puzzle.solvedState.turnOnTile(2, 0);
		puzzle.solvedState.turnOnTile(2, 1);
		puzzle.solvedState.turnOnTile(2, 2);
		puzzle.solvedState.turnOnTile(2, 4);
		puzzles.add(puzzle);
	}
	
	private void addFourthPuzzle(List<Puzzle> puzzles) {
		int size = 5;
		Puzzle puzzle = new Puzzle();
		
		puzzle.clue = "Iron";
		
		puzzle.initialState = new Grid(size,size);
		puzzle.initialState.turnOnTile(0, 0);
		puzzle.initialState.turnOnTile(0, 2);
		puzzle.initialState.turnOnTile(0, 4);
		
		puzzle.initialState.turnOnTile(1, 1);
		puzzle.initialState.turnOnTile(1, 3);
		
		puzzle.initialState.turnOnTile(2, 0);
		puzzle.initialState.turnOnTile(2, 2);
		puzzle.initialState.turnOnTile(2, 4);
		
		puzzle.initialState.turnOnTile(3, 1);
		puzzle.initialState.turnOnTile(3, 3);
		
		puzzle.initialState.turnOnTile(4, 0);
		puzzle.initialState.turnOnTile(4, 1);
		puzzle.initialState.turnOnTile(4, 2);
		puzzle.initialState.turnOnTile(4, 3);
		puzzle.initialState.turnOnTile(4, 4);
		
		puzzle.solvedState = new Grid(size,size);
		puzzle.solvedState.turnOnTile(0, 0);
		puzzle.solvedState.turnOnTile(0, 1);
		puzzle.solvedState.turnOnTile(0, 2);
		puzzle.solvedState.turnOnTile(0, 3);
		puzzle.solvedState.turnOnTile(0, 4);
		
		puzzle.solvedState.turnOnTile(1, 2);
		puzzle.solvedState.turnOnTile(1, 4);
		
		puzzle.solvedState.turnOnTile(3, 0);
		puzzle.solvedState.turnOnTile(3, 1);
		puzzle.solvedState.turnOnTile(3, 2);
		puzzle.solvedState.turnOnTile(3, 3);
		puzzle.solvedState.turnOnTile(3, 4);
		
		puzzle.solvedState.turnOnTile(4, 4);
		puzzle.solvedState.turnOnTile(4, 2);
		puzzle.solvedState.turnOnTile(4, 0);
		puzzles.add(puzzle);
	}

}
