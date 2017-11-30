package freeboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.action.IAction;
import org.dimigo.service.FreeBoardService;
import org.springframework.beans.factory.annotation.Autowired;

import freeboard.vo.DeleteRequest;
import user.vo.UserVo;

/**
 * <pre>
 * org.dimigo.action |_ DeleteFreeBoardAction
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 19.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class DeleteAction implements IAction {
	@Autowired
	private FreeBoardService service;
	private String SUCCESS_FORM = "/freeboard/list.do";

	public DeleteRequest toDeleteRequest(HttpServletRequest request) {
		return new DeleteRequest((UserVo) request.getSession().getAttribute("user"),
				Integer.parseInt(request.getParameter("articleNumber")));
	}

	@Override
	public void processForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
		DeleteRequest deleteRequest = toDeleteRequest(request);

		deleteRequest.validate();

		service.delete(deleteRequest);

		// 포워딩 필요
		response.sendRedirect(request.getContextPath() + SUCCESS_FORM);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			forward(request, response, "/jsp/index.jsp");
		}
	}
}
