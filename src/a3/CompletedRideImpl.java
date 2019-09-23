package a3;

public class CompletedRideImpl implements CompletedRide {

	private RideRequest _Request;
	private Driver _Driver;
	private int _WTime;
	private int _TTime;
	private Position _driverPosition;
	private Position _clientPosition;
	private double _cost;
	private double _price;
	private double _profit;

	public CompletedRideImpl(RideRequest request, Driver driver) {

		this._Request = request;
		this._Driver = driver;
		this._WTime = _WTime;
		this._driverPosition = driver.getVehicle().getPosition();
		this._clientPosition = request.getClientPosition();

		this._TTime = _TTime;
		this._cost = _cost;
		this._price = _price;
		this._profit = _profit;

	}

	
	public RideRequest getRequest() {

		return _Request;
	}

	
	public Driver getDriver() {

		return _Driver;
	}

	public int getWaitTime() {

		return _clientPosition.getManhattanDistanceTo(_driverPosition);
	}

	public int getTotalTime() {
		
		return (_Request.getRideTime() + getWaitTime());
	}

	public double getCost() {


		return (((double) (.50 * getRequest().getRideTime())) + ((double) (.10 * getWaitTime())));

	}

	public double getPrice() {

		double wait = getWaitTime();
		double r = getRequest().getRideTime();

		if (getWaitTime() < 25) {
			return r * 2.5;
		} else if (getWaitTime() >= 25 && getWaitTime() <= 49) {
			return r * 2;
		} else if (getWaitTime() >= 50 && getWaitTime() <= 99) {
			return r;
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
