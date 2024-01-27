package parkinglot.controller;

import parkinglot.dto.IssueTicketRequest;
import parkinglot.dto.IssueTicketResponse;
import parkinglot.models.Ticket;
import parkinglot.service.TicketService;

public class TicketController {

	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	public IssueTicketResponse issueTicket(IssueTicketRequest reuest) {
		Ticket ticket = ticketService.issueTicket(null, 0);

		return new IssueTicketResponse();
	}
}
