package matt.and.jessica;

public class Tile {
	
	public boolean isDarkened;
	private int x;
	private int y;
	public boolean isSelected;
	
	public Tile(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Tile(Tile tile) {
		this.x = tile.x;
		this.y = tile.y;
		this.isDarkened = tile.isDarkened;
	}

	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isDarkened ? 1231 : 1237);
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		if (isDarkened != other.isDarkened)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
