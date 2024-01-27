package parkinglot.strategy;

import parkinglot.models.Gate;
import parkinglot.models.ParkingSpot;
import parkinglot.models.VehicleType;

public interface SpotAssignmentStrategy {

	ParkingSpot getSpot(Long parkingSpotId,Gate gate, VehicleType vehicletype);

}
