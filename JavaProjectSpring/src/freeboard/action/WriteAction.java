package freeboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.action.IAction;
import org.dimigo.service.FreeBoardService;
import org.springframework.beans.factory.annotation.Autowired;

import freeboard.vo.WriteRequest;
import user.vo.UserVo;

/**
 * <pre>
 * org.dimigo.action |_ WriteFreeBoardAction
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 19.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class WriteAction implements IAction {
	@Autowired
	private FreeBoardService service;
	private static final String SUCCESS_FORM = "/freeboard/list.do";
	private static final String VIEW_FORM = "/jsp/write.jsp";

	@Override
	public void processForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		forward(request, response, VIEW_FORM);
	}

	// POST 메소드일 경우
	public void processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {

			WriteRequest writeRequest = toWriteRequest(request);

			writeRequest.validate();

			service.write(writeRequest);

			// 포워딩 필요
			response.sendRedirect(request.getContextPath() + SUCCESS_FORM);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WriteRequest toWriteRequest(HttpServletRequest request) {
		return new WriteRequest((UserVo) request.getSession().getAttribute("user"),
				request.getParameter("title"), request.getParameter("content"));
	}

}
