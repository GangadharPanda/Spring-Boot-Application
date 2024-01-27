package parkinglot.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import parkinglot.models.Vehicle;

public class VehicleRepository {

	private Map<String, Vehicle> vehicles = new HashMap<>();

	public Optional<Vehicle> findVehicleById(String vehicleNumber) {
		if (vehicles.containsKey(vehicleNumber)) {
			return Optional.of(vehicles.get(vehicleNumber));
		}
		return Optional.empty();
	}

	public void save(String vehicleNumber, Vehicle vehicle) {
		vehicles.put(vehicleNumber, vehicle);
	}

}
