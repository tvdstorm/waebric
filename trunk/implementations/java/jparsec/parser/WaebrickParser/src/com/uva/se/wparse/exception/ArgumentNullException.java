package com.uva.se.wparse.exception;

/**
 * An exception that indicates that an argument isn't initialized. 
 */
public class ArgumentNullException extends ApplicationException {

	/**
	 * Creates an Exception which indicates that an argument is null. 
	 * 
	 * @param The name of the parameter which is null.
	 */
	public ArgumentNullException(String parameterName) {
		super(message(parameterName));
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7389819961334807334L;

	/**
	 * The message which will be displayed. The {0} is replaced with the <i>parameterName</i>.
	 */
	private static final String MESSAGE = "The argument {0} can't be null.";
	
	/**
	 * Constructs a Message which will be used in the 
	 * @param	parameterName: the name of the parameter which is null.
	 * @return 	the message which will saved in the ArgumentNullException.
	 */
	private static String message(String parameterName) {
		return MESSAGE.replace("{0}", parameterName);
	}
	
	
}
