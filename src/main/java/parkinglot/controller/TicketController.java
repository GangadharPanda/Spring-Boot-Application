package parkinglot.controller;

import parkinglot.dto.IssueTicketRequest;
import parkinglot.dto.IssueTicketResponse;
import parkinglot.exceptions.GateNotFoundException;
import parkinglot.exceptions.ParkingSpotNotFoundException;
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
		} catch (ParkingSpotNotFoundException e) {
			throw new RuntimeException("No Spot is available for this kind of vehicle");
		}

		return IssueTicketResponse.builder().ticketNumber(ticket.getTicketNumber())
				.spotNumber(ticket.getParkingSpot().getSpotNumber()).entryTime(ticket.getEntryTime())
				.floorNumber(ticket.getParkingSpot().getParkingFloor().getFloorNumber())
				.vehicleNumber(ticket.getVehicle().getVehicleNumber()).generatedBy(ticket.getGeneratedBy())
				.gateNumber(ticket.getGeneratedAt().getGateNumber()).build();
	}
}
