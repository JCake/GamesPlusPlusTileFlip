package matt.and.jessica;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GridRenderer extends ClearableRenderer{
	
	private Grid grid;
	private Grid solutionOutline;
	
	public void setSolutionOutline(Grid solutionOutline){
		this.solutionOutline = solutionOutline;
	}
	
	public GridRenderer(Grid grid){
		this.grid = grid;
		this.solutionOutline = null;
	}
	
	public void setGrid(Grid grid){
		this.grid = grid;
	}
	
	int gridRenderedWidth;
	int gridRenderedHeight;
	int gridRenderedX;
	int gridRenderedY;

	public void resize(int screenWidth, int screenHeight){
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.gridRenderedWidth = screenWidth / 2;
		this.gridRenderedHeight = screenHeight / 2;
		this.gridRenderedX = screenWidth / 4;
		this.gridRenderedY = screenHeight / 4;
		System.out.println("set dimensions to: " + gridRenderedWidth + "x" + gridRenderedHeight);
		System.out.println("set x,y coords to: " + gridRenderedX + "," + gridRenderedY);
	}
	
	public int getWidth(){
		return gridRenderedWidth;
	}
	
	public int getHeight(){
		return gridRenderedHeight;
	}

	public void render(){
		float xUnit = gridRenderedWidth / grid.getWidth();
		float yUnit = gridRenderedHeight / grid.getHeight();
		shapeRenderer.begin(ShapeType.FilledRectangle);
		shapeRenderer.filledRect(gridRenderedX, gridRenderedY, gridRenderedWidth, gridRenderedHeight);
		for(int x = 0; x < grid.tiles.length; x++){
			for(int y = 0; y < grid.tiles[0].length; y++){
				shapeRenderer.setColor(grid.tiles[x][y].isDarkened ? Color.BLUE : Color.WHITE);
				if(grid.tiles[x][y].isSelected){
					shapeRenderer.setColor(Color.YELLOW);
				}
				shapeRenderer.filledRect(x * xUnit + gridRenderedX, y * yUnit + gridRenderedY, xUnit - 1, yUnit - 1);
			}
		}
		shapeRenderer.end();
		
		shapeRenderer.begin(ShapeType.Rectangle);
		shapeRenderer.setColor(Color.BLACK);
		if(solutionOutline != null){
			for(int x = 0; x < solutionOutline.tiles.length; x++){
				for(int y = 0; y < solutionOutline.tiles[0].length; y++){
					if(solutionOutline.tiles[x][y].isDarkened){
						shapeRenderer.setColor(Color.RED);
						shapeRenderer.rect(x * xUnit + gridRenderedX, y * yUnit + gridRenderedY, xUnit, yUnit);
						
					}
				}
			}
		}
		shapeRenderer.setColor(Color.BLACK);
		shapeRenderer.end();
	}
}
