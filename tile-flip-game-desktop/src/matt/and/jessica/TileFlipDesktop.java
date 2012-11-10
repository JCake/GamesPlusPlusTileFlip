package matt.and.jessica;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class TileFlipDesktop {

	public static void main(String[] args){
		new LwjglApplication(new TileFlipGame(500,500), "Tile Flip", 500, 500, true);
	}
}
