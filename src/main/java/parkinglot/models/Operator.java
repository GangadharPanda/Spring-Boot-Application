package parkinglot.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Operator {
	private String empid;
	private String name;
}
