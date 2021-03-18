package exceptions;

public class ElementNotEnabledException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ElementNotEnabledException(String message) {
		super(message);
	}

}
