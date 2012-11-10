package matt.and.jessica;

public class Puzzle {
	
	public String clue;
	public Grid initialState;
	public Grid solvedState;
	public boolean outlineSolution = false;
	
	public Puzzle(){
		
	}
	
	public Puzzle(int width, int height){
		this.initialState = new Grid(width, height);
		this.solvedState = new Grid(width, height);
	}

}
