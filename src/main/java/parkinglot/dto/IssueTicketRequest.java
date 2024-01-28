package parkinglot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import parkinglot.models.Operator;
import parkinglot.models.VehicleType;

@Getter
@Setter
@Builder
public class IssueTicketRequest {
	private String vehicleNumber;
	private long gateId;
	private VehicleType vehicleType;
	private Operator generatedBy;
}
