package a3;

public class CompletedRideImpl implements CompletedRide {
	
	RideRequest _request;
	Driver _driver;

	public CompletedRideImpl(RideRequest request, Driver driver) {
		this._request = request;
		this._driver = driver;
	}
	
	
	
	public RideRequest getRequest() {
		
		return _request;
	}

	
	public Driver getDriver() {
		
		return _driver;
	}

	
	public int getWaitTime() {
		
		return ((RideRequestImpl)_request).getClientOriginalPosition().getManhattanDistanceTo(((VehicleImpl)_driver.getVehicle()).getOriginalPosition());
	}

	
	public int getTotalTime() {
		
		return (getWaitTime() + _request.getRideTime());
	}


	public double getCost() {
		double Wtime = getWaitTime();
		double Rtime = _request.getRideTime();
		return (Rtime/2) + (Wtime/10);
	}

	
	public double getPrice() {
		if (getWaitTime()<25) {
			return Double.valueOf((_request.getRideTime()*25));
		}
		else if (getWaitTime()>=25 && getWaitTime()<= 49) {
			return Double.valueOf((_request.getRideTime()*2));
		}
		else if (getWaitTime()>=50 && getWaitTime()<= 99) {
			return Double.valueOf((_request.getRideTime()*1));
		}
		else if (getWaitTime()>=100) {
			return Double.valueOf((_request.getRideTime()*.5));
		}
		else {
			return 0;
		}
	}

	
	public double getProfit() {
		
		return (getWaitTime() + _request.getRideTime());
	}

}
