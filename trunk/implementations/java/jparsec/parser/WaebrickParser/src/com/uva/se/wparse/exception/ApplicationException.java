package com.uva.se.wparse.exception;

public abstract class ApplicationException extends Exception {

	private static final long serialVersionUID = -3404976041156607572L;

	/**
	 * Create 
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create an Exception based on the  
	 * 
	 * @param message is the message to display in the frontend. 
	 */
	public ApplicationException(String message) {
		super(message);
	}
}
