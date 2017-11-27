package freeboard.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.action.IAction;
import org.dimigo.service.FreeBoardService;
import org.dimigo.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;

import freeboard.vo.ArticleData;

/**
 * <pre>
 * org.dimigo.action |_ ReadFreeBoardAction
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 21.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class ReadAction implements IAction {
	@Autowired
	private FreeBoardService service;
	private static final String SUCCESS_FORM = "/jsp/read.jsp";

	private int toArticleNumber(HttpServletRequest request) throws Exception {
		try {
			String page = request.getParameter("number");
			if (CommonUtil.isEmpty(page)) {
				return 1;
			} else {
				int pageNumber = Integer.parseInt(page);
				return pageNumber;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new Exception("글 번호가 숫자가 아닙니다");
		}
	}

	@Override
	public void processForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int number = toArticleNumber(request);

			ArticleData result = service.read(number, true);

			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher(SUCCESS_FORM);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
