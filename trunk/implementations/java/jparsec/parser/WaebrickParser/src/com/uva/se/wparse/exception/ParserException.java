package com.uva.se.wparse.exception;

/**
 * 
 * @author Lammert
 *
 */
public class ParserException extends ApplicationException {

	/**
	 * Use for serialization purposes in the Java framework.
	 */
	private static final long serialVersionUID = 4607072939419051604L;

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public ParserException(String message, Throwable cause) {
		super(message, cause);
	}
}
