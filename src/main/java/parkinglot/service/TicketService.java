package parkinglot.service;

import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.repository.GateRepository;

public class TicketService {

	private final GateRepository gateRepository;

	public TicketService(GateRepository gateRepository) {
		this.gateRepository = gateRepository;
	}

	public Ticket issueTicket(Vehicle vehicle, int gateNumber) {
		// Create a Ticket Object

		// Select a parking Spot

		// fetch all the information of current gate using the gateNumber

		// Save Ticket Number and vehicle info into DB

		// Return the ticket object
		return new Ticket();
	}

}
