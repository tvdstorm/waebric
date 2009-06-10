/*
 * File			: ApplicationException.java
 * Project		: WaebrickParser2
 * 				: Waebrick Parser, practicum opdracht Software Construction
 * 
 * Author		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * Description	:
 * 
 * 
 * Change history
 * -----------------------------------------------------------
 * Date			Change				 
 * -----------------------------------------------------------
 * 07-05-2009	Initial version.
 * 
 * 
 */
package com.uva.se.wparse.exception;

/**
 * This Exception indicates it is an exception which is thrown in this
 * application.
 */
public abstract class ApplicationException extends Exception {

	/**
	 * Use for serialization purposes in the Java framework.
	 */
	private static final long serialVersionUID = 4934099892011252008L;

	/**
	 * Create an ApplicationException, based on a message and an Exception which
	 * is wrapped in this Exception.
	 * 
	 * @param message
	 *            The message which is displayed in the frontend.
	 * @param cause
	 *            The exception which is rethrowed wrapped in this
	 *            ApplicationException.
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Created an ApplicationException based on a message.
	 * 
	 * @param message
	 *            The message to display in the frontend.
	 */
	public ApplicationException(String message) {
		super(message);
	}
}
