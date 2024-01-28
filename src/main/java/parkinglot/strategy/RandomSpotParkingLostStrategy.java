package parkinglot.strategy;

import parkinglot.models.Gate;
import parkinglot.models.ParkingFloor;
import parkinglot.models.ParkingLot;
import parkinglot.models.ParkingSpot;
import parkinglot.models.ParkingSpotStatus;
import parkinglot.models.VehicleType;
import parkinglot.repository.ParkingLotRepository;

public class RandomSpotParkingLostStrategy implements SpotAssignmentStrategy {

	ParkingLotRepository lotRepository;

	public RandomSpotParkingLostStrategy(ParkingLotRepository lotRepository) {
		this.lotRepository = lotRepository;
	}

	@Override
	public ParkingSpot getSpot(Long parkingSpotId, Gate gate, VehicleType vehicletype) {
		// Get all the available parking Spots
		ParkingLot lot = lotRepository.findParkingLotById(1L).get();

		for (ParkingFloor floor : lot.getParkingFloors()) {
			for (ParkingSpot spot : floor.getParkingSpots()) {
				if (spot.getAllowedVehicleTypes() == vehicletype
						&& spot.getParkingSpotStatus() == ParkingSpotStatus.AVAILABLE) {
					return spot;
				}
			}
		}

		return null;
	}

}
