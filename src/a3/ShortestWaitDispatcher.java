package a3;

public class ShortestWaitDispatcher implements Dispatcher {
	
	private int _min_wait_idx;
	private int _min_wait;
	
	public ShortestWaitDispatcher() {
		_min_wait = Integer.MAX_VALUE;
		_min_wait_idx = -1;
	}

	@Override
	public Driver chooseDriver(Driver[] availableDrivers, RideRequest request) {
		for (int i = 0; i < availableDrivers.length; i++) {
			Position driver_position = availableDrivers[i].getVehicle().getPosition();
			int wait_time = request.getClientPosition().getManhattanDistanceTo(driver_position);
			
			if (wait_time < _min_wait) {
				_min_wait = wait_time;
				_min_wait_idx = i;
			}
		}
		
		return availableDrivers[_min_wait_idx];
	}

}
