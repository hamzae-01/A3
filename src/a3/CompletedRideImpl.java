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
		
		return _driver.getVehicle().getPosition().getManhattanDistanceTo(_request.getClientPosition());
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
		int Wtime = getWaitTime();
		
		if (Wtime<25) {
			return Double.valueOf((_request.getRideTime()*2.5));
		}
		else if (Wtime>=25 && Wtime<= 49) {
			return Double.valueOf((_request.getRideTime()*2));
		}
		else if (Wtime>=50 && Wtime<= 99) {
			return Double.valueOf(_request.getRideTime());
		}
		else if (Wtime>=100) {
			return Double.valueOf((_request.getRideTime()*.5));
		}
		else {
			return 0;
		}
	}

	
	public double getProfit() {

		return (getPrice() - getCost());
	}

}
