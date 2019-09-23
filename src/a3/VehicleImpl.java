package a3;

public class VehicleImpl implements Vehicle {

	String _make;
	String _model;
	String _plate;
	int _mileage;
	Position _position;
	//Position _originalPosition; // added this to complete completed ride

	public VehicleImpl(String make, String model, String plate, Position position) {

		if (make == null) {
			throw new RuntimeException("make is null");
		}
		if (model == null) {
			throw new RuntimeException("model is null");
		}
		if (plate == null) {
			throw new RuntimeException("plate is null");
		}
		if (position == null) {
			throw new RuntimeException("position is null");
		}

		this._make = make;
		this._model = model;
		this._plate = plate;
		this._mileage = 0;
		this._position = position;
	}

	public String getMake() {

		return _make;
	}

	public String getModel() {

		return _model;
	}

	public String getPlate() {

		return _plate;
	}

	public int getMileage() {

		return _mileage;
	}

	public Position getPosition() {

		return _position;
	}

	/*public Position getOriginalPosition() {

		return _originalPosition;
	}*/

	public void moveToPosition(Position p) {

		_mileage += _position.getManhattanDistanceTo(p);
		_position = p;

	}

}
