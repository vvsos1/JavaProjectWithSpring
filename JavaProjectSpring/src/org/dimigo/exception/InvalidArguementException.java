package org.dimigo.exception;

/**
 * <pre>
 * nettyInActionWebSocket
 * 	 |_ InvalidArguementException
 *
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 5.
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class InvalidArguementException extends Exception {

	private static final long serialVersionUID = 4310507225021798667L;
	
	public InvalidArguementException() {
		super();
	}
	
	public InvalidArguementException(String message) {
		super(message);
	}

}
