package matt.and.jessica;

import matt.and.jessica.screens.GameScreen;
import matt.and.jessica.screens.TitleScreen;

import com.badlogic.gdx.Game;

public class TileFlipGame extends Game {

	private final int width;
	private final int height;

	public TileFlipGame(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void create() {
		setScreen(new TitleScreen(this,new GameScreen(PuzzleFactory.puzzles(), width, height)));
	}
	
}
