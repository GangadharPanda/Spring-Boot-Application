package parkinglot.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import parkinglot.models.Operator;

@Getter
@Setter
@Builder
@ToString
public class IssueTicketResponse {

	private String ticketNumber;
	private long floorNumber;
	private long spotNumber;
	private long gateNumber;
	private Date entryTime;
	private String vehicleNumber;
	private Operator generatedBy;
}
