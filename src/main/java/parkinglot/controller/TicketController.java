package parkinglot.controller;

import parkinglot.dto.IssueTicketRequest;
import parkinglot.dto.IssueTicketResponse;
import parkinglot.exceptions.GateNotFoundException;
import parkinglot.models.Ticket;
import parkinglot.service.TicketService;

public class TicketController {

	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	public IssueTicketResponse issueTicket(IssueTicketRequest request) {
		Ticket ticket;
		try {
			ticket = ticketService.issueTicket(request.getVehicleNumber(), request.getVehicleType(),
					request.getGateId());
		} catch (GateNotFoundException e) {
			throw new RuntimeException("Invalid gate");
		}

		return IssueTicketResponse.builder().ticketNumber(ticket.getTicketNumber())
				.floorNumber(ticket.getParkingSpot().getSpotNumber()).entryTime(ticket.getEntryTime())
				.vehicleNumber(ticket.getVehicle().getVehicleNumber())
				.gateNumber(ticket.getGeneratedAt().getGateNumber()).build();
	}
}
