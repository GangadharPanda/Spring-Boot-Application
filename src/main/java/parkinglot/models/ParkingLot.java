package parkinglot.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingLot {
	private String name;
	private String address;
	List<ParkingFloor> parkingFloors;
	List<Gate> entryGates;
	List<Gate> exitGates;
}
