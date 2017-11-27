package org.dimigo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 * org.dimigo.action |_ IAction
 *
 * 1. 개요 : 2. 작성일 : 2017. 10. 31.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public interface IAction {
	default void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String method = request.getMethod();
		if ("GET".equalsIgnoreCase(method)) {
			processForm(request, response);
		} else if ("POST".equalsIgnoreCase(method)) {
			processSubmit(request, response);
		} else {
			// METHOD_NOT_ALLOWED
			response.sendError(405);
		}
	}

	default void processForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		processSubmit(request, response);
	}

	default void processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		processForm(request, response);
	}

	default void forward(HttpServletRequest request, HttpServletResponse response, String view)
			throws ServletException, IOException {
		request.getRequestDispatcher(view).forward(request, response);
	}
}
