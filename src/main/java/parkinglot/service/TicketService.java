package parkinglot.service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import parkinglot.exceptions.GateNotFoundException;
import parkinglot.models.Gate;
import parkinglot.models.ParkingSpot;
import parkinglot.models.ParkingSpotStatus;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.models.VehicleType;
import parkinglot.repository.GateRepository;
import parkinglot.repository.ParkingSpotRepository;
import parkinglot.repository.TicketRepository;
import parkinglot.repository.VehicleRepository;
import parkinglot.strategy.SpotAssignmentStrategy;

public class TicketService {

	private final GateRepository gateRepository;
	private final VehicleRepository vehicleRepository;
	private final TicketRepository ticketRepository;
	private final ParkingSpotRepository spotRepository;
	private final SpotAssignmentStrategy strategy;

	public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository,
			TicketRepository ticketRepository, SpotAssignmentStrategy strategy, ParkingSpotRepository spotRepository) {
		this.gateRepository = gateRepository;
		this.vehicleRepository = vehicleRepository;
		this.ticketRepository = ticketRepository;
		this.spotRepository = spotRepository;
		this.strategy = strategy;
	}

	public Ticket issueTicket(String vehicleNumber, VehicleType vehicleType, long gateNumber)
			throws GateNotFoundException {
		// Create a Ticket Object
		Ticket ticket = new Ticket();

		// fetch all the information of current gate using the gateNumber
		Optional<Gate> gateOptional = gateRepository.findGateById(gateNumber);
		if (gateOptional.isEmpty()) {
			throw new GateNotFoundException("Invalid Gate number ");
		}

		Gate gate = gateOptional.get();

		ticket.setEntryTime(new Date());
		ticket.setGeneratedAt(gate);
		ticket.setGeneratedBy(gate.getCurrentOperator());

		// fetch all the information of the vehicle, if we have saved
		// already in there?
		Vehicle savedVehicle;

		Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleById(vehicleNumber);
		if (vehicleOptional.isEmpty()) {
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleNumber(vehicleNumber);
			vehicle.setVehicleType(vehicleType);
			vehicleRepository.save(vehicleNumber, vehicle);
			savedVehicle = vehicle;
		} else {
			savedVehicle = vehicleOptional.get();
		}

		ticket.setVehicle(savedVehicle);
		ticket.setTicketNumber(Instant.EPOCH.toString());

		// Find Parking Spot
		ParkingSpot spot = strategy.getSpot(1L, gate, vehicleType);
		spot.setVehicle(savedVehicle);
		spot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);

		spotRepository.save(1l, spot);
		ticket.setParkingSpot(spot);

		ticketRepository.save(vehicleNumber, ticket);
		// Save Ticket Number into DB

		// Return the ticket object
		return ticket;
	}

}
