package a3;

public class VehicleImpl implements Vehicle{
	
	String _make; 
	String _model; 
	String _plate;
	int _mileage;
	Position _position;
	Position _originalPosition; //added this to complete completed ride
	
	public VehicleImpl(String make, String model, String plate, Position position) {
		
		if(make == null) {
			throw new RuntimeException("firstName is null");
			}
			if(model == null) {
			throw new RuntimeException("lastName is null");
			}
			if(plate == null) {
			throw new RuntimeException("lastName is null");
			}
			if(position == null) {
			throw new RuntimeException("lastName is null");
			}
			
		this._make = make; 
		this. _model = model; 
		this. _plate = plate;
		this._mileage = 0;
		this. _position = position;
	}

	@Override
	public String getMake() {
		// TODO Auto-generated method stub
		return _make;
	}

	@Override
	public String getModel() {
		// TODO Auto-generated method stub
		return _model;
	}

	@Override
	public String getPlate() {
		// TODO Auto-generated method stub
		return _plate;
	}

	@Override
	public int getMileage() {
		// TODO Auto-generated method stub
		return _mileage;
	}

	public Position getPosition() {
		// TODO Auto-generated method stub
		return _position;
	}
	
	public Position getOriginalPosition() {
		// TODO Auto-generated method stub
		return _originalPosition;
	}

	@Override
	public void moveToPosition(Position p) {
		// TODO Auto-generated method stub
		_position.getManhattanDistanceTo(p);
		_position = p;
			
		
	}

}
