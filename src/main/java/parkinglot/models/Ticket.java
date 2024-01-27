package parkinglot.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {

	private String ticketNumber;
	private Date entryTime;
	private Vehicle vehicle;
	private ParkingSpot parkingSpot;
	private Gate generatedAt;
	private Operator generatedBy;

}
