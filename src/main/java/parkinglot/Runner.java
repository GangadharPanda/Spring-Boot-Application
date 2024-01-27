package parkinglot;

import parkinglot.controller.TicketController;
import parkinglot.dto.IssueTicketRequest;
import parkinglot.models.Gate;
import parkinglot.models.GateType;
import parkinglot.models.Operator;
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

		gateRepository.save(1L, Gate.builder().gateNumber(1L).gateType(GateType.ENTRY)
				.currentOperator(Operator.builder().name("Gangadhar").empid("123").build()).build());
		
		System.out.println("Gate is create and associated with the Operator");
		
		System.out.println(gateRepository.findGateById(1L));
		
		//---------------------------------------------------------

		ParkingLotRepository lotRepository = new ParkingLotRepository();
		VehicleRepository vehicleRepository = new VehicleRepository();
		TicketRepository ticketRepository = new TicketRepository();
		ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

		SpotAssignmentStrategy strategy = new RandomSpotParkingLostStrategy(lotRepository);

		TicketService serviceTicketService = new TicketService(gateRepository, vehicleRepository, ticketRepository,
				strategy, parkingSpotRepository);

		TicketController controller = new TicketController(serviceTicketService);

		controller.issueTicket(
				IssueTicketRequest.builder().gateId(1L).vehicleNumber("123456").vehicleType(VehicleType.SMALL).build());
	}

}
