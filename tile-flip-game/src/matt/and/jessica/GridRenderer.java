package matt.and.jessica;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GridRenderer {
	
	ShapeRenderer renderer = new ShapeRenderer();
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
	
	int gridRenderedWidth = 150;
	int gridRenderedHeight = 150;
	int gridRenderedX = 75;
	int gridRenderedY = 75;
	
	public void resize(int screenWidth, int screenHeight){
		this.gridRenderedWidth = screenWidth / 2;
		this.gridRenderedHeight = screenHeight / 2;
		this.gridRenderedX = screenWidth / 4;
		this.gridRenderedY = screenHeight / 4;
	}
	
	public int getWidth(){
		return gridRenderedWidth;
	}
	
	public int getHeight(){
		return gridRenderedHeight;
	}

	public void render(){
		int xUnit = gridRenderedWidth / grid.getWidth();
		int yUnit = gridRenderedHeight / grid.getHeight();
//		debugRenderer.setProjectionMatrix(cam.combined);
		renderer.begin(ShapeType.FilledRectangle);
		renderer.filledRect(gridRenderedX, gridRenderedY, gridRenderedWidth, gridRenderedHeight);
		for(int x = 0; x < grid.tiles.length; x++){
			for(int y = 0; y < grid.tiles[0].length; y++){
				renderer.setColor(grid.tiles[x][y].isDarkened ? Color.BLUE : Color.WHITE);
				if(grid.tiles[x][y].isSelected){
					renderer.setColor(Color.YELLOW);
				}
				renderer.filledRect(x * xUnit + gridRenderedX, y * yUnit + gridRenderedY, xUnit - 1, yUnit - 1);
			}
		}
		renderer.end();
		
		renderer.begin(ShapeType.Rectangle);
		renderer.setColor(Color.BLACK);
		if(solutionOutline != null){
			for(int x = 0; x < solutionOutline.tiles.length; x++){
				for(int y = 0; y < solutionOutline.tiles[0].length; y++){
					if(solutionOutline.tiles[x][y].isDarkened){
						renderer.setColor(Color.RED);
						renderer.rect(x * xUnit + gridRenderedX, y * yUnit + gridRenderedY, xUnit, yUnit);
						
					}
				}
			}
		}
		renderer.setColor(Color.BLACK);
		renderer.end();
	}
}
