package a3;

public class ShortestWaitDispatcher implements Dispatcher {
	
	//private int _min_wait_idx;
	//private int _min_wait;

	
	public ShortestWaitDispatcher() {
		/*_min_wait = Integer.MAX_VALUE;
		_min_wait_idx = -1;*/
	}

	@Override
	public Driver chooseDriver(Driver[] availableDrivers, RideRequest request) {
		int smallestDistance = 100000;
		int index = -1;
		for (int i = 0; i < availableDrivers.length; i++) {
			Position driver_position = availableDrivers[i].getVehicle().getPosition();
			int Mandistance = ((RideRequestImpl)request).getClientOriginalPosition().getManhattanDistanceTo(driver_position);
			
			if (Mandistance < smallestDistance) {
				smallestDistance = i;
				Mandistance = smallestDistance;
				
			}
		}
		
		return availableDrivers[smallestDistance];
	}

}
