package com.uva.se.wparse.exception;

public abstract class ApplicationException extends Exception {

	private static final long serialVersionUID = -3404976041156607572L;

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}


}
