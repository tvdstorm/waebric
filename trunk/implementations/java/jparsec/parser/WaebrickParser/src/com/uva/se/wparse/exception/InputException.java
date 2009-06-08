package com.uva.se.wparse.exception;

public class InputException extends ApplicationException {

	/**
	 * Use for serialization purposes in the Java framework.
	 */
	private static final long serialVersionUID = 4571952543814133802L;

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public InputException(String message, Throwable cause) {
		super(message, cause);
	}

	
}
