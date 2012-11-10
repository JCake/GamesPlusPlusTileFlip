package matt.and.jessica.renderers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TileFlipGameRenderer {

	protected ShapeRenderer shapeRenderer = new ShapeRenderer();
	protected int screenWidth = 300;
	protected int screenHeight = 300;
//	private OrthographicCamera cam; //Was trying to get camera working... it isn't doing much
	
	public TileFlipGameRenderer(){
//		this.cam = new OrthographicCamera(screenWidth, screenHeight);
//		this.cam.position.set(0,0,0);
//		this.cam.update();
	}
	
	public void render(){
//		shapeRenderer.setProjectionMatrix(cam.combined);
	}

}
