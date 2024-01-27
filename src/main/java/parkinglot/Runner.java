package parkinglot;

import parkinglot.controller.TicketController;
import parkinglot.dto.IssueTicketRequest;
import parkinglot.models.VehicleType;
import parkinglot.repository.GateRepository;
import parkinglot.repository.ParkingLotRepository;
import parkinglot.repository.ParkingSpotRepository;
import parkinglot.repository.TicketRepository;
import parkinglot.repository.VehicleRepository;
import parkinglot.service.TicketService;
import parkinglot.strategy.RandomSpotParkingLostStrategy;
import parkinglot.strategy.SpotAssignmentStrategy;

public class Runner {

	public static void main(String[] args) {
		System.out.println("Hello ");

		GateRepository gateRepository = new GateRepository();
		ParkingLotRepository lotRepository = new ParkingLotRepository();
		VehicleRepository vehicleRepository = new VehicleRepository();
		TicketRepository ticketRepository = new TicketRepository();
		ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

		SpotAssignmentStrategy strategy = new RandomSpotParkingLostStrategy(lotRepository);

		TicketService serviceTicketService = new TicketService(gateRepository, vehicleRepository, ticketRepository,
				strategy, parkingSpotRepository);

		TicketController controller = new TicketController(serviceTicketService);

		controller.issueTicket(
				IssueTicketRequest.builder().gateId(1).vehicleNumber("123456").vehicleType(VehicleType.SMALL).build());
	}

}
