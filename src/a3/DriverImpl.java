package a3;

public class DriverImpl implements Driver {

	String _first;
	String _last;
	int _id;
	Vehicle _vehicle;

	public DriverImpl(String first, String last, int id, Vehicle vehicle) {

		if (first == null) {
			throw new RuntimeException("fistName is null");
		}
		if (last == null) {
			throw new RuntimeException("lastName is null");
		}
		if (vehicle == null) {
			throw new RuntimeException("vehicle is null");
		}

		this._first = first;
		this._last = last;
		this._id = id;
		this._vehicle = vehicle;
	}

	public String getFirstName() {

		return _first;
	}

	public String getLastName() {

		return _last;
	}

	public String getFullName() {

		return _first + " " + _last;
	}

	public int getID() {

		return _id;
	}

	public Vehicle getVehicle() {

		return _vehicle;
	}

	public void setVehicle(Vehicle v) {
		if (v == null) {
			throw new RuntimeException("v is null");
		}
		
		_vehicle = v;

	}

}
