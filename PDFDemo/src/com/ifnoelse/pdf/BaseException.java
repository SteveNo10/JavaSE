package com.ifnoelse.pdf;

public class BaseException extends Exception {

	private static final long serialVersionUID = 8028706388670678504L;

	public BaseException() {
		super();
	}
	
	public BaseException(String message) {
		super(message);
	}
	
	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BaseException(Throwable cause) {
		super(cause);
	}
}
