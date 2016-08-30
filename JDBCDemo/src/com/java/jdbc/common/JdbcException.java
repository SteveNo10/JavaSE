package com.java.jdbc.common;

public class JdbcException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2922040626023405254L;
	
	public JdbcException() {
		super();
	}
	
	public JdbcException(String message) {
		super(message);
	}
	
	public JdbcException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public JdbcException(Throwable cause) {
        super(cause);
    }
}
