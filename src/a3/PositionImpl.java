package a3;

public class PositionImpl implements Position {
	
	int _x;
	int _y;
	// feilds
	
	public PositionImpl(int x, int y) {
		// give fields values
		this._x = x;
		this._y = y; 
	}

	
	public int getX() {
		
		return _x;
	}

	
	public int getY() {
		
		return _y;
	}

	
	public int getManhattanDistanceTo(Position p) {
		
		//int xValue = p.getX();
		//int yValue = p.getY();
		return (Math.abs(_x - p.getX())+ Math.abs(_y - p.getY()));
	}
	
	

}
