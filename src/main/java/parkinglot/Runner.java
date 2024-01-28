package parkinglot;

import java.util.List;

import parkinglot.controller.TicketController;
import parkinglot.dto.IssueTicketRequest;
import parkinglot.dto.IssueTicketResponse;
import parkinglot.models.Gate;
import parkinglot.models.GateType;
import parkinglot.models.Operator;
import parkinglot.models.ParkingFloor;
import parkinglot.models.ParkingLot;
import parkinglot.models.ParkingSpot;
import parkinglot.models.ParkingSpotStatus;
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
		VehicleRepository vehicleRepository = new VehicleRepository();
		TicketRepository ticketRepository = new TicketRepository();
		ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
		ParkingLotRepository lotRepository = new ParkingLotRepository();

		Gate gate1 = Gate.builder().gateNumber(1L).gateType(GateType.ENTRY)
				.currentOperator(Operator.builder().name("Gangadhar").empid("123").build()).build();

		gateRepository.save(1L, gate1);

		Gate gate2 = Gate.builder().gateNumber(2L).gateType(GateType.EXIT)
				.currentOperator(Operator.builder().name("XYZ").empid("1234").build()).build();

		gateRepository.save(2L, gate2);

		System.out.println("Gate is create and associated with the Operator");

		System.out.println(gateRepository.findGateById(1L));

		// ---------------------------------------------------------

		ParkingSpot parkingSpot1 = new ParkingSpot();
		parkingSpot1.setAllowedVehicleTypes(VehicleType.MEDIUM);
		parkingSpot1.setSpotNumber(1L);
		parkingSpot1.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
		parkingSpot1.setParkingFloor(null);

		ParkingSpot parkingSpot2 = new ParkingSpot();
		parkingSpot2.setAllowedVehicleTypes(VehicleType.SMALL);
		parkingSpot2.setSpotNumber(2L);
		parkingSpot2.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
		parkingSpot2.setParkingFloor(null);

		ParkingSpot parkingSpot3 = new ParkingSpot();
		parkingSpot3.setAllowedVehicleTypes(VehicleType.SMALL);
		parkingSpot3.setSpotNumber(3L);
		parkingSpot3.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
		parkingSpot3.setParkingFloor(null);

		ParkingFloor floor = new ParkingFloor();
		floor.setFloorNumber(1L);
		floor.setParkingSpots(List.of(parkingSpot1, parkingSpot2, parkingSpot3));

		parkingSpot1.setParkingFloor(floor);
		parkingSpot2.setParkingFloor(floor);
		parkingSpot3.setParkingFloor(floor);

		parkingSpotRepository.save(1L, parkingSpot1);
		parkingSpotRepository.save(2L, parkingSpot2);
		parkingSpotRepository.save(3L, parkingSpot3);

		ParkingLot lot = new ParkingLot();
		lot.setId(1L);
		lot.setEntryGates(List.of(gate1));
		lot.setExitGates(List.of(gate2));
		lot.setName("--------------------- My Parking Lot -------------------");
		lot.setParkingFloors(List.of(floor));

		lotRepository.save(1L, lot);

		SpotAssignmentStrategy strategy = new RandomSpotParkingLostStrategy(lotRepository);

		TicketService serviceTicketService = new TicketService(gateRepository, vehicleRepository, ticketRepository,
				strategy, parkingSpotRepository);

		TicketController controller = new TicketController(serviceTicketService);

		IssueTicketResponse response = controller.issueTicket(IssueTicketRequest.builder().gateId(1L)
				.vehicleNumber("123456").vehicleType(VehicleType.SMALL)
				.generatedBy(Operator.builder().name("Gangadhar").empid("123").build()).build());

		System.out.println(response);
	}

}
