package matt.and.jessica.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class ClueRenderer extends ClearableRenderer {
	
	private String clue;
	private SpriteBatch spriteBatch;
	
	public ClueRenderer(String clue){
		this.clue = clue;
		spriteBatch = new SpriteBatch();
	}

	public void setClue(String clue){
		this.clue = clue;
	}
	
	public void resize(int screenWidth, int screenHeight){
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}
	
	public void render(){
		shapeRenderer.begin(ShapeType.FilledRectangle);
		shapeRenderer.setColor(Color.WHITE);
		shapeRenderer.filledRect(0, 0, screenWidth, 30);
		shapeRenderer.setColor(Color.BLACK);
		shapeRenderer.end();
		
		BitmapFont font = new BitmapFont(Gdx.files.internal("whitefont.fnt"),
		         Gdx.files.internal("whitefont_0.png"), false);
		font.setColor(Color.BLUE);
		spriteBatch.setColor(Color.BLUE);
		spriteBatch.begin();
		font.draw(spriteBatch, clue, 1, 25);
		spriteBatch.end();
	}
}
