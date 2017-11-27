package org.dimigo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import user.vo.UserVo;

/**
 * <pre>
 * org.dimigo.filter
 * 	 |_ PermissionCheckFilter
 *
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 20.
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
@WebFilter
public class PermissionFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		UserVo user = (UserVo) session.getAttribute("user");
		if (user == null) {
//			String requestUrl = req.getRequestURL().toString();
			request.setAttribute("error", new Exception("로그인 후 이용해주세요"));
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/index.jsp");
			rd.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
