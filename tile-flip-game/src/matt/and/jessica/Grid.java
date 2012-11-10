package matt.and.jessica;

import java.util.Arrays;

public class Grid {
	
	private final int width;
	private final int height;
	public Tile[][] tiles;
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public Grid(int width, int height){
		this.width = width;
		this.height = height;
		tiles = new Tile[width][height];
		for(int x = 0; x < tiles.length; x++)
			for(int y = 0; y < tiles.length; y++)
				tiles[x][y] = new Tile(x,y);
	}
	
	public Grid(Grid toCopy) {
		this.width = toCopy.width;
		this.height = toCopy.height;
		this.tiles = new Tile[width][height];
		for(int x = 0; x < tiles.length; x++)
			for(int y = 0; y < tiles.length; y++)
				tiles[x][y] = new Tile(toCopy.tiles[x][y]);
		
	}

	public void turnOnTile(int x, int y){
		tiles[x][y].isDarkened = true;
	}

	public void displayWin() {
		for(int x = 0; x < tiles.length; x++)
			for(int y = 0; y < tiles.length; y++)
				tiles[x][y].isSelected = true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + Arrays.hashCode(tiles);
		result = prime * result + width;
		return result;
	}

	@Override //FIXME this doesn't seem to work
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grid other = (Grid) obj;
		if (height != other.height)
			return false;
		if (!Arrays.equals(tiles, other.tiles))
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	public void clearSelection() {
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				tiles[x][y].isSelected = false;
			}
		}
		
	}
	

}
