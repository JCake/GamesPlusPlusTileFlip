package matt.and.jessica;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GridRenderer {
	
	ShapeRenderer renderer = new ShapeRenderer();
	private final Grid grid;
	
	public GridRenderer(Grid grid){
		this.grid = grid;
	}
	
	int width = 300;
	int height = 300;
	
	public void resize(int width, int height){
		this.width = width;
		this.height = height;
	}

	public void render(){
		int xUnit = width / grid.getWidth();
		int yUnit = height / grid.getHeight();
//		debugRenderer.setProjectionMatrix(cam.combined);
		renderer.begin(ShapeType.FilledRectangle);
		for(int x = 0; x < grid.tiles.length; x++){
			for(int y = 0; y < grid.tiles[0].length; y++){
				renderer.setColor(grid.tiles[x][y].isDarkened ? Color.BLUE : Color.WHITE);
				if(grid.tiles[x][y].isSelected){
					renderer.setColor(Color.YELLOW);
				}
				renderer.filledRect(x * xUnit, y * yUnit, xUnit - 1, yUnit - 1);
			}
		}
		renderer.end();
	}
}
