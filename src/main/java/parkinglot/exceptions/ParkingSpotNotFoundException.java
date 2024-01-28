package parkinglot.exceptions;

public class ParkingSpotNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParkingSpotNotFoundException(String message) {
		super(message);
	}
	
	public ParkingSpotNotFoundException() {
	}


}
