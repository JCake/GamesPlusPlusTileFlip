package matt.and.jessica;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class ClearableRenderer {

	protected ShapeRenderer shapeRenderer = new ShapeRenderer();
	protected int screenWidth = 300;
	protected int screenHeight = 300;

	public void clear() {
		shapeRenderer.begin(ShapeType.FilledRectangle);
		shapeRenderer.setColor(Color.BLACK);
		shapeRenderer.filledRect(0, 0, screenWidth, screenWidth);
		shapeRenderer.end();
		
	}
}
