package parkinglot.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IssueTicketResponse {

	private String ticketNumber;
	private int floorNumber;
	private int slotNumber;
	private int gateNumber;
	private Date entryTime;
	private String vehicleNumber;
}
