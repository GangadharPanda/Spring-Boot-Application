package parkinglot.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingFloor {

	private long floorNumber;
	private List<ParkingSpot> parkingSpots;
}
