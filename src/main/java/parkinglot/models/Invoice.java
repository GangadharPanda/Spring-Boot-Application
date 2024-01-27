package parkinglot.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Invoice {
	String invoiceNumber;
	private Date exitTime;
	private Ticket ticket;
	private Gate generatedAt;
	private Operator generatedBy;
	private PaymentType paymentType;
}
