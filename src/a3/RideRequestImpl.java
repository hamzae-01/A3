 package a3;

public class RideRequestImpl implements RideRequest{
	
	Position _clientPosition;
	Position _clientOriginalPosition;
	Position _destination;
	boolean _isComplete;
	CompletedRide _completedRide;
	
	public RideRequestImpl(Position clientPosition, Position destination) {
		
		if(clientPosition != null) {
			this._clientPosition = clientPosition;
			
			}else {
				throw new RuntimeException("Cannot have null Position");
			}
		this. _clientOriginalPosition = clientPosition;
		if(destination != null) {
			this._destination = destination;
			
			}else {
				throw new RuntimeException("Cannot have null Destination Position");
			}
		
		//this._clientPosition = clientPosition;
		//this. _clientOriginalPosition = clientPosition;
		this. _destination = destination;
		this. _isComplete = false;
		this. _completedRide = null;
	}

	
	public Position getClientPosition() {

		return _clientPosition;
	}

	
	public Position getClientOriginalPosition() {

		return _clientOriginalPosition;
	}

	public Position getDestination() {
		
		return _destination;
	}

	
	public boolean getIsComplete() {
		
		return _isComplete;
	}

	@Override
	public CompletedRide complete(Driver driver) {
		if (getIsComplete() == false) {
			_isComplete = true;
			_completedRide = new CompletedRideImpl(this, driver);
			driver.getVehicle().moveToPosition(getClientPosition());
			driver.getVehicle().moveToPosition(getDestination());
			return _completedRide;
		}else {
		return _completedRide;
		}

	}

	@Override
	public int getRideTime() {
		// TODO Auto-generated method stub
		return _clientPosition.getManhattanDistanceTo(_destination);
		
		
		
		
		
	}

}
