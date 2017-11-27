package freeboard.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.action.IAction;
import org.dimigo.service.FreeBoardService;
import org.dimigo.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;

import freeboard.vo.ArticlePage;

/**
 * <pre>
 * org.dimigo.action |_ ListFreeBoardAction
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 19.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class ListAction implements IAction {
	@Autowired
	private FreeBoardService service;
	private String SUCCESS_FORM = "/jsp/list.jsp";

	private int toPageNumber(HttpServletRequest request) throws Exception {
		try {
			String page = request.getParameter("page");
			if (CommonUtil.isEmpty(page)) {
				return 1;
			} else {
				int pageNumber = Integer.parseInt(page);
				return pageNumber;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new Exception("페이지 번호가 숫자가 아닙니다");
		}
	}

	@Override
	public void processForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int page = toPageNumber(request);

			ArticlePage result = service.list(page);

			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher(SUCCESS_FORM);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
