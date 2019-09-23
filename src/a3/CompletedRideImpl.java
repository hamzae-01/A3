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
		return (((double) (.50 * getRequest().getRideTime())) + ((double) (.10 *getWaitTime())));
	}

	
	public double getPrice() {
		// TODO Auto-generated method stub
		double wait = getWaitTime();
		double r = getRequest().getRideTime();


		if (getWaitTime() < 25) {
		return r * 2.5;
		} else if (getWaitTime() >= 25 && getWaitTime() <= 49) {
		return r * 2;
		} else if (getWaitTime() >= 50 && getWaitTime() <= 99) {
		return r ;
		} else if (getWaitTime() >= 100) {
		return r * .5;
		} else {
		return 0;
		}
		}

	
	public double getProfit() {

		return (getPrice() - getCost());
	}

}
