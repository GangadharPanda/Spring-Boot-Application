package parkinglot.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;

public class TicketRepository {

	private Map<String, Ticket> tickets = new HashMap<>();

	public Optional<Ticket> findTicketById(String ticketNumber) {
		if (tickets.containsKey(ticketNumber)) {
			return Optional.of(tickets.get(ticketNumber));
		}
		return Optional.empty();
	}
	
	public void save(String ticketNumber, Ticket ticket) {
		tickets.put(ticketNumber, ticket);
	}

}
