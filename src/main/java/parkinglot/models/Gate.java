package parkinglot.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Gate {
	private long gateNumber;
	private Operator currentOperator;
	private GateType gateType;
}
