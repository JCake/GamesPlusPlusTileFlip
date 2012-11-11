package matt.and.jessica.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class MovesRenderer extends TileFlipGameRenderer {
	
	public int moves = 0;
	private SpriteBatch spriteBatch;
	private int best;
	
	public MovesRenderer(int best){
		this.best = best;
		spriteBatch = new SpriteBatch();
	}
	
	public void resize(int screenWidth, int screenHeight){
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}
	
	public void render(){
		shapeRenderer.begin(ShapeType.FilledRectangle);
		shapeRenderer.setColor(Color.WHITE);
		shapeRenderer.filledRect(0, screenHeight - screenHeight/10, screenWidth, screenHeight/10);
		shapeRenderer.setColor(Color.BLACK);
		shapeRenderer.end();
		
		BitmapFont font = new BitmapFont(Gdx.files.internal("whitefont.fnt"),
		         Gdx.files.internal("whitefont_0.png"), false);
		font.setColor(Color.BLUE);
		spriteBatch.setColor(Color.BLUE);
		spriteBatch.begin();
		font.draw(spriteBatch, "Moves: " + moves + "      Best: " + displayBest(), 1, screenHeight - 1);
		spriteBatch.end();
	}

	private String displayBest() {
		if (best > 9999) {
			return "";
		}
		return String.valueOf(best);
	}

}
