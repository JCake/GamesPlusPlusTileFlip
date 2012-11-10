package matt.and.jessica;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Game;

public class TileFlipGame  extends Game {

	@Override
	public void create() {
		List<Puzzle> puzzles = new ArrayList<Puzzle>();
		Puzzle firstPuzzle = new Puzzle();
		int size = 3;
		firstPuzzle.initialState = new Grid(size,size);
		for(int i = 0; i < size; i++){
			firstPuzzle.initialState.turnOnTile(i, i);
		}
		firstPuzzle.solvedState = new Grid(size,size);
		for(int i = 0; i < size; i++){
			firstPuzzle.solvedState.turnOnTile(0, i);
		}
		puzzles.add(firstPuzzle );
		setScreen(new GameScreen(puzzles));
		
	}

}
