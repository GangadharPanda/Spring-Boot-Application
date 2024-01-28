package parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot {
	
	private long spotNumber;
	private ParkingFloor parkingFloor;
	private ParkingSpotStatus parkingSpotStatus;
	private VehicleType allowedVehicleTypes;
	private Vehicle vehicle;
}
