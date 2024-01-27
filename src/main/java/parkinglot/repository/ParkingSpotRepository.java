package parkinglot.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import parkinglot.models.ParkingSpot;
import parkinglot.models.Vehicle;

public class ParkingSpotRepository {

	private Map<Long, ParkingSpot> parkingSpots = new HashMap<>();

	public Optional<ParkingSpot> findParkingLotById(Long spotNumber) {
		if (parkingSpots.containsKey(spotNumber)) {
			return Optional.of(parkingSpots.get(spotNumber));
		}
		return Optional.empty();
	}

	public void save(Long spotNumber, ParkingSpot parkingSpot) {
		parkingSpots.put(spotNumber, parkingSpot);
	}

}
