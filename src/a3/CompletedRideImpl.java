package a3;

public class CompletedRideImpl implements CompletedRide {

	private RideRequest Request;
	private Driver Driver;
	private int WaitTime;
	private int TotalTime;
	private Position driverposition;
	private Position clientposition;
	private double Cost;
	private double Price;
	private double Profit;

	public CompletedRideImpl(RideRequest request, Driver driver) {

		this.Request = request;
		this.Driver = driver;
		this.WaitTime = WaitTime;
		this.driverposition = driver.getVehicle().getPosition();
		this.clientposition = request.getClientPosition();

		this.TotalTime = TotalTime;
		this.Cost = Cost;
		this.Price = Price;
		this.Profit = Profit;

	}

	@Override
	public RideRequest getRequest() {
// TODO Auto-generated method stub
		return Request;
	}

	@Override
	public Driver getDriver() {
// TODO Auto-generated method stub
		return Driver;
	}

	public int getWaitTime() {
// TODO Auto-generated method stub
		return clientposition.getManhattanDistanceTo(driverposition);
	}

	public int getTotalTime() {
// TODO Auto-generated method stub
		return (Request.getRideTime() + getWaitTime());
	}

	public double getCost() {
// TODO Auto-generated method stub

		return (((double) (.50 * getRequest().getRideTime())) + ((double) (.10 * getWaitTime())));

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
