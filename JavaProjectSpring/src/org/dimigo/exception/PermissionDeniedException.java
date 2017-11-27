package org.dimigo.exception;

/**
 * <pre>
 * org.dimigo.service
 * 	 |_ PermissionDeniedException
 *
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 17.
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class PermissionDeniedException extends Exception {

	private static final long serialVersionUID = -2527636336340659478L;
	
	public PermissionDeniedException(String message) {
		super(message);
	}
	
	public PermissionDeniedException() {
		super();
	}
}
