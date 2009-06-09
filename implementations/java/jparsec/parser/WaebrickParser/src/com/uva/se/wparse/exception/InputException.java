package com.uva.se.wparse.exception;

/**
 * This InputException indicates that there was an error in the input of the
 * parser application.
 */
public class InputException extends ApplicationException {

	/**
	 * Use for serialization purposes in the Java framework.
	 */
	private static final long serialVersionUID = 4571952543814133802L;

	/**
	 * Creates an InputException based on a message an Exception which was
	 * thrown by the the underlying methods.
	 * 
	 * @param message
	 *            The message to display in the frontend.
	 * @param cause
	 *            The exception which was thrown by the underlying methods.
	 */
	public InputException(String message, Throwable cause) {
		super(message, cause);
	}

}
