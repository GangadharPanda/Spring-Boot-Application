package parkinglot.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import parkinglot.models.Gate;
import parkinglot.models.Vehicle;

public class GateRepository {

	private Map<Long, Gate> gates = new HashMap<>();

	public Optional<Gate> findGateById(Long id) {
		if (gates.containsKey(id)) {
			return Optional.of(gates.get(id));
		}
		return Optional.empty();
	}

	public void save(Long id, Gate gate) {
		gates.put(id, gate);
	}

}
