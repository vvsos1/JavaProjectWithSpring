package org.dimigo.servlet;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.action.IAction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext context;
	private Map<String, IAction> actions = new HashMap<>();;

	public ActionServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		try {
			System.out.println(getServletContext().getRealPath("/WEB-INF/applicationContext.xml"));
			context = new FileSystemXmlApplicationContext(getServletContext().getRealPath("/WEB-INF/applicationContext.xml"));
			Properties prop = new Properties();
			prop.load(new FileReader(new File(getServletContext().getRealPath("/WEB-INF/actionMapping.properties"))));

			for (Entry<Object, Object> entry : prop.entrySet()) {
				System.out.println(entry.getKey() + " : " +entry.getValue());
				IAction action = (IAction) context.getBean(Class.forName((String) entry.getValue()));
				actions.put((String) entry.getKey(), action);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");

			String actionName = request.getRequestURI();
			if (actionName.indexOf(request.getContextPath()) == 0) {
				actionName = actionName.substring(request.getContextPath().length());
			}
			System.out.println("actionName : " + actionName);

			// actions Map으로부터 action 객체 가져오기
//			IAction action = getAction(actionName);
			IAction action = actions.get(actionName);
			if (action == null) {
				throw new Exception(actionName + "에 해당하는 Action 클래스가 없습니다.");
			}

			// action 객체의 execute() 메소드 실행
			action.execute(request, response);

		} catch (Exception e) {
			 e.printStackTrace();
//			 request.setAttribute("error", e.getMessage());
			// RequestDispatcher rd =
			// request.getRequestDispatcher("jsp/error.jsp");
			// rd.forward(request, response);
		}
	}
}
