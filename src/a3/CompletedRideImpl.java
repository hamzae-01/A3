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
		
		return _request.getClientPosition().getManhattanDistanceTo(_driver.getVehicle().getPosition());
	}

	
	public int getTotalTime() {
		
		return (getWaitTime() + _request.getRideTime());
	}


	public double getCost() {
		double Wtime = getWaitTime();
		double Rtime = _request.getRideTime();
		return (Rtime * 0.5) + (Wtime * 0.1);
	}

	
	public double getPrice() {
		int Wtime = getWaitTime();
		int Rtime = _request.getRideTime();
		
		if (Wtime<25) {
			return Double.valueOf(Rtime*2.5);
		}
		else if (Wtime>=25 && Wtime<= 49) {
			return Double.valueOf(Rtime*2);
		}
		else if (Wtime>=50 && Wtime<= 99) {
			return Double.valueOf(Rtime);
		}
		else if (Wtime>=100) {
			return Double.valueOf(Rtime*.5);
		}
		else {
			return 0;
		}
	}

	
	public double getProfit() {

		return (getPrice() - getCost());
	}

}
