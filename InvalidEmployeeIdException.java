package com.codegnan.exception;

public class InvalidEmployeeIdException extends Exception {

	public InvalidEmployeeIdException() {
		
	}

	public InvalidEmployeeIdException(String message) {
		super(message);
		
	}

	public InvalidEmployeeIdException(Throwable cause) {
		super(cause);
		
	}

	public InvalidEmployeeIdException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidEmployeeIdException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
