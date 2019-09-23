package a3;

public class ShortButFairDispatcher implements Dispatcher {
	
	Driver[] exempt_drivers;
	int[] counters;
	
	private int _min_wait_idx;
	private int _min_wait;
	
	public ShortButFairDispatcher() {
		exempt_drivers = new Driver[5];
		counters = new int[5];
		
		_min_wait = Integer.MAX_VALUE;
		_min_wait_idx = -1;
	}

	@Override
	public Driver chooseDriver(Driver[] availableDrivers, RideRequest request) {
		for (int i = 0; i < availableDrivers.length; i++) {
			Position driver_position = availableDrivers[i].getVehicle().getPosition();
			int wait_time = ((RideRequestImpl)request).getClientOriginalPosition().getManhattanDistanceTo(driver_position);
			
			for (int j = 0; j < exempt_drivers.length; j++) {
				if (availableDrivers[i] == exempt_drivers[j]) {
					continue;
				}
			}
			
			if (wait_time < _min_wait) {
				_min_wait = wait_time;
				_min_wait_idx = i;
			}
		}
		
		for (int k = 0; k < exempt_drivers.length; k++) {
			if (exempt_drivers[k] != null) {
				continue;
			}
			
			exempt_drivers[k] = availableDrivers[_min_wait_idx];
			counters[k] = 0;
			break;
		}
		
		for (int k = 0; k < exempt_drivers.length; k++) {
			if (counters[k] == 4) {
				exempt_drivers[k] = null;
				counters[k] = 0;
			} else {
				counters[k]++;
			}
		}
		
		return availableDrivers[_min_wait_idx];
	}

}
