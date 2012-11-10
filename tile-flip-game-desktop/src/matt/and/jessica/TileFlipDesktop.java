package matt.and.jessica;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class TileFlipDesktop {

	public static void main(String[] args){
		new LwjglApplication(new TileFlipGame(), "Tile Flip", 300, 300, true);
	}
}
