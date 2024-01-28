package parkinglot.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import parkinglot.models.Gate;
import parkinglot.models.ParkingLot;

public class ParkingLotRepository {

	private Map<Long, ParkingLot> parkingLots = new HashMap<>();

	public Optional<ParkingLot> findParkingLotById(Long id) {
		if (parkingLots.containsKey(id)) {
			return Optional.of(parkingLots.get(id));
		}
		return Optional.empty();
	}

	public void save(Long id, ParkingLot parkingLot) {
		parkingLots.put(id, parkingLot);
	}

}
