/*
 * File			: ParserException.java
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
 * This ParserException indicates that there was an error in the parsing process
 * of the parser application.
 */
public class ParserException extends ApplicationException {

	/**
	 * Use for serialization purposes in the Java framework.
	 */
	private static final long serialVersionUID = 4607072939419051604L;

	/**
	 * Creates an ParserException based on a message an Exception which was
	 * thrown by the the underlying methods.
	 * 
	 * @param message
	 *            The message to display in the frontend.
	 * @param cause
	 *            The exception which was thrown by the underlying methods.
	 */
	public ParserException(String message, Throwable cause) {
		super(message, cause);
	}
}
