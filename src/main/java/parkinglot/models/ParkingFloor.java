package parkinglot.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingFloor {

	private int floorNumber;
	private List<ParkingSpot> parkingSpots;
}
