package parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot {
	
	private int spotNumber;
	private ParkingFloor parkingfloor;
	private ParkingSpotStatus parkingSpotStatus;
	private VehicleType allowedVehicleTypes;
	private Vehicle vehicle;
}
