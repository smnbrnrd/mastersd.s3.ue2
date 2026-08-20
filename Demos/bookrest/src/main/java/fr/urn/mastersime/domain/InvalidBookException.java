package fr.urn.mastersime.domain;

public class InvalidBookException extends Exception {

	private static final long serialVersionUID = -9158442902635974449L;

	public InvalidBookException() {
		super();
	}

	public InvalidBookException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidBookException(String message) {
		super(message);
	}

	public InvalidBookException(Throwable cause) {
		super(cause);
	}

}
