package matt.and.jessica;

import matt.and.jessica.screens.GameScreen;

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
		setScreen(new GameScreen(PuzzleFactory.puzzles(), width, height));
	}
}
