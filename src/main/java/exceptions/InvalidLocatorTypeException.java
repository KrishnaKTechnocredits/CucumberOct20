package exceptions;

public class InvalidLocatorTypeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidLocatorTypeException(String message) {
		super(message);
		
	}
}
