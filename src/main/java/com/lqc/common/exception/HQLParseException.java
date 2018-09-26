package com.lqc.common.exception;

/**
 * Exception - HQL转换
 * @author liqc
 */
public class HQLParseException extends RuntimeException {
	
	private static final long serialVersionUID = -8729537215617057048L;
	
	public HQLParseException() {
		super();
	}
	
	public HQLParseException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public HQLParseException(String message) {
		super(message);
	}
	
	public HQLParseException(Throwable cause) {
		super(cause);
	}

}
