package matt.and.jessica;

import java.util.ArrayList;
import java.util.List;

public class PuzzleFactory {

	public static List<Puzzle> puzzles() {
		return new PuzzleFactory().makePuzzles();
	}
	
	private List<Puzzle> makePuzzles() {
		List<Puzzle> puzzles = new ArrayList<Puzzle>();
//		puzzles.add(triforcePuzzle());
		puzzles.add(squarePuzzle());
		puzzles.add(xPuzzle());
		puzzles.add(iPuzzle());
		puzzles.add(golfPuzzle());
		puzzles.add(smilePuzzle());
		puzzles.add(heartPuzzle());
		puzzles.add(gemPuzzle());
		puzzles.add(stairsPuzzle());
		puzzles.add(ironPuzzle());
		puzzles.add(onePuzzle());
		return puzzles;
	}
	
	private Puzzle heartPuzzle() {
		int size = 5;
		Puzzle puzzle = new Puzzle(size, size);
		puzzle.clue = "Symbol of love";
		
		puzzle.initialState.turnOnTile(0, 2);
		
		puzzle.initialState.turnOnTile(1, 3);
		puzzle.initialState.turnOnTile(1, 1);
		
		puzzle.initialState.turnOnTile(2, 0);
		puzzle.initialState.turnOnTile(2, 4);
		
		puzzle.initialState.turnOnTile(3, 1);
		puzzle.initialState.turnOnTile(3, 3);
		
		puzzle.initialState.turnOnTile(4, 2);
		
		puzzle.solvedState.turnOnTile(2, 0);
		
		puzzle.solvedState.turnOnTile(1, 1);
		puzzle.solvedState.turnOnTile(3, 1);
		
		puzzle.solvedState.turnOnTile(0, 2);
		puzzle.solvedState.turnOnTile(4, 2);
		
		puzzle.solvedState.turnOnTile(0, 3);
		puzzle.solvedState.turnOnTile(2, 3);
		puzzle.solvedState.turnOnTile(4, 3);
		
		puzzle.solvedState.turnOnTile(1, 4);
		puzzle.solvedState.turnOnTile(3, 4);
		
		puzzle.outlineSolution = true;
		
		return puzzle;
	}
	
	private Puzzle stairsPuzzle() {
		int size = 5;
		Puzzle puzzle = new Puzzle(size,size);
		
		puzzle.clue = "Stairs down to the right";
		
		puzzle.initialState.turnOnTile(2, 3);
		puzzle.initialState.turnOnTile(2, 2);
		puzzle.initialState.turnOnTile(2, 1);
		puzzle.initialState.turnOnTile(3, 2);
		puzzle.initialState.turnOnTile(1, 2);
		
		for(int x = 0; x < size; x++){
			puzzle.solvedState.turnOnTile(x, 0);
		}
		for(int x = 0; x < size - 1; x++){
			puzzle.solvedState.turnOnTile(x, 1);
		}
		for(int x = 0; x < 3; x++){
			puzzle.solvedState.turnOnTile(x, 2);
		}
		puzzle.solvedState.turnOnTile(0, 3);
		puzzle.solvedState.turnOnTile(1, 3);
		puzzle.solvedState.turnOnTile(0, 4);
		
		puzzle.outlineSolution = true;
		
		return puzzle;
	}
	
	private Puzzle smilePuzzle() {
		int size = 5;
		Puzzle puzzle = new Puzzle(size,size);
		puzzle.clue = "Don't worry!";
		puzzle.initialState.turnOnTile(0, 0);
		puzzle.initialState.turnOnTile(0, 1);
		puzzle.initialState.turnOnTile(3, 1);
		puzzle.initialState.turnOnTile(3, 2);
		puzzle.initialState.turnOnTile(2, 1);
		
		puzzle.solvedState.turnOnTile(0, 1);
		puzzle.solvedState.turnOnTile(1, 0);
		puzzle.solvedState.turnOnTile(2, 0);
		puzzle.solvedState.turnOnTile(3, 0);
		puzzle.solvedState.turnOnTile(4, 1);
		
		puzzle.solvedState.turnOnTile(2, 2);
		puzzle.solvedState.turnOnTile(1, 3);
		puzzle.solvedState.turnOnTile(3, 3);
		
		puzzle.outlineSolution = true;
		
		return puzzle;
	}

	private Puzzle squarePuzzle() {
		int size = 4;
		Puzzle puzzle = new Puzzle(size, size);
		puzzle.clue = "Don't be a ______";
		puzzle.initialState.turnOnTile(0, 0);
		puzzle.initialState.turnOnTile(3, 3);
		puzzle.initialState.turnOnTile(1, 2);
		puzzle.initialState.turnOnTile(2, 1);
		puzzle.solvedState.turnOnTile(1, 1);
		puzzle.solvedState.turnOnTile(1, 2);
		puzzle.solvedState.turnOnTile(2, 1);
		puzzle.solvedState.turnOnTile(2, 2);
		puzzle.outlineSolution = true;
		return puzzle;
	}

	private Puzzle golfPuzzle() {
		int size = 4;
		Puzzle puzzle = new Puzzle(size,size);
		puzzle.clue = "Fore!";
		puzzle.initialState.turnOnTile(0, 0);
		puzzle.initialState.turnOnTile(1, 1);
		puzzle.initialState.turnOnTile(2, 2);
		puzzle.initialState.turnOnTile(1, 2);
		puzzle.initialState.turnOnTile(2, 1);
		puzzle.solvedState.turnOnTile(1, 0);
		puzzle.solvedState.turnOnTile(2, 0);
		puzzle.solvedState.turnOnTile(2, 1);
		puzzle.solvedState.turnOnTile(2, 2);
		puzzle.solvedState.turnOnTile(2, 3);
		puzzle.outlineSolution = true;
		return puzzle;
	}
	
	private Puzzle iPuzzle() {
		int size = 5;
		Puzzle puzzle = new Puzzle(size,size);
		puzzle.clue = "Me, myself";
		
		puzzle.initialState.turnOnTile(0, 4);
		puzzle.initialState.turnOnTile(1, 4);
		puzzle.initialState.turnOnTile(2, 3);
		puzzle.initialState.turnOnTile(3, 1);
		puzzle.initialState.turnOnTile(4, 0);
		
		//TODO make capital I?
		puzzle.solvedState.turnOnTile(2, 0);
		puzzle.solvedState.turnOnTile(2, 1);
		puzzle.solvedState.turnOnTile(2, 2);
		puzzle.solvedState.turnOnTile(2, 4);
		
		puzzle.outlineSolution = true;
		return puzzle;
	}
	
	private Puzzle ironPuzzle() {
		int size = 5;
		Puzzle puzzle = new Puzzle(size, size);
		
		puzzle.clue = "Iron's Chemical Symbol";
		
		puzzle.initialState.turnOnTile(1, 0);
		puzzle.initialState.turnOnTile(1, 2);
		puzzle.initialState.turnOnTile(1, 4);
		
		puzzle.initialState.turnOnTile(0, 1);
		puzzle.initialState.turnOnTile(0, 3);
		
		puzzle.initialState.turnOnTile(3, 0);
		puzzle.initialState.turnOnTile(3, 2);
		puzzle.initialState.turnOnTile(3, 4);
		
		puzzle.initialState.turnOnTile(2, 1);
		puzzle.initialState.turnOnTile(2, 3);
		
		puzzle.initialState.turnOnTile(4, 0);
		puzzle.initialState.turnOnTile(4, 1);
		puzzle.initialState.turnOnTile(4, 2);
		puzzle.initialState.turnOnTile(4, 3);
		puzzle.initialState.turnOnTile(4, 4);
		
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
		
		puzzle.outlineSolution = true;
		return puzzle;
	}
	
	private Puzzle gemPuzzle(){
		int size = 5;
		Puzzle puzzle = new Puzzle();
		
		puzzle.clue = "A Gem";
		
		puzzle.initialState = new Grid(size,size);
		for(int x = 0; x < size; x++){
			puzzle.initialState.turnOnTile(x, 0);
			puzzle.initialState.turnOnTile(x, size - 1);
		}
		for(int y = 0; y < size; y++){
			puzzle.initialState.turnOnTile(0, y);
			puzzle.initialState.turnOnTile(size - 1, y);
		}
		
		puzzle.solvedState = new Grid(size,size);
		for(int y = 0; y < size; y++){
			puzzle.solvedState.turnOnTile(2, y);
			if(y > 0 && y < size-1){
				puzzle.solvedState.turnOnTile(1, y);
				puzzle.solvedState.turnOnTile(3, y);
			}
		}
		
		puzzle.outlineSolution = true;
		return puzzle;
	}
	
	private Puzzle onePuzzle(){
		int height = 6;
		int width = 5;
		Puzzle puzzle = new Puzzle(width,height);
		
		puzzle.clue = "You're Number _!";
		
		for(int x = 0; x < width; x++){
			puzzle.initialState.turnOnTile(x, 0);
			puzzle.initialState.turnOnTile(x, height - 1);
		}
		for(int y = 0; y < height; y++){
			puzzle.initialState.turnOnTile(0, y);
			puzzle.initialState.turnOnTile(width - 1, y);
		}
		
		for(int x = 0; x < width; x++){
			puzzle.solvedState.turnOnTile(x, 0);
		}
		for(int y = 0; y < height; y++){
			puzzle.solvedState.turnOnTile(2, y);
		}
		puzzle.solvedState.turnOnTile(0, 3);
		puzzle.solvedState.turnOnTile(1, 4);
		
		puzzle.outlineSolution = true;
		return puzzle;
	}
	
	private Puzzle xPuzzle(){
		int size = 5;
		Puzzle puzzle = new Puzzle(size, size);
		puzzle.clue = "Marks the Spot";
		
		puzzle.initialState.turnOnTile(2, 2);
		
		for(int i = 0; i < size; i++){
			puzzle.solvedState.turnOnTile(i, i);
			puzzle.solvedState.turnOnTile(i, size - 1 -i);
		}
		
		puzzle.outlineSolution = true;
		
		return puzzle;
	}
	
	private Puzzle triforcePuzzle() {
		int width = 9;
		int height = 5;
		Puzzle puzzle = new Puzzle(width, height);
		
		puzzle.clue = "Triforce";
		
		puzzle.initialState.turnOnTile(1, 0);
		puzzle.initialState.turnOnTile(1, 2);
		puzzle.initialState.turnOnTile(1, 4);
		
		puzzle.initialState.turnOnTile(0, 1);
		puzzle.initialState.turnOnTile(0, 3);
		
		puzzle.initialState.turnOnTile(3, 0);
		puzzle.initialState.turnOnTile(3, 2);
		puzzle.initialState.turnOnTile(3, 4);
		
		puzzle.initialState.turnOnTile(2, 1);
		puzzle.initialState.turnOnTile(2, 3);
		
		puzzle.initialState.turnOnTile(4, 0);
		puzzle.initialState.turnOnTile(4, 1);
		puzzle.initialState.turnOnTile(4, 2);
		puzzle.initialState.turnOnTile(4, 3);
		puzzle.initialState.turnOnTile(4, 4);
		
		for(int x = 0; x < width; x++){
			puzzle.solvedState.turnOnTile(x, 0);
		}
		puzzle.solvedState.turnOnTile(1, 1);
		puzzle.solvedState.turnOnTile(3, 1);
		puzzle.solvedState.turnOnTile(5, 1);
		puzzle.solvedState.turnOnTile(7, 1);
		
		for(int x = 2; x < width-2; x++){
			puzzle.solvedState.turnOnTile(x, 2);
		}
		puzzle.solvedState.turnOnTile(3, 3);
		puzzle.solvedState.turnOnTile(4, 4);
		puzzle.solvedState.turnOnTile(5, 3);
		
		puzzle.outlineSolution = true;
		return puzzle;
	}
}
