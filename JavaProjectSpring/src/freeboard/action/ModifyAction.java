package freeboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.action.IAction;
import org.dimigo.service.FreeBoardService;
import org.dimigo.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;

import freeboard.vo.ArticleData;
import freeboard.vo.ModifyRequest;
import user.vo.UserVo;

/**
 * <pre>
 * org.dimigo.action
 * 	 |_ DeleteFreeBoardAction
 *
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 19.
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class ModifyAction implements IAction{
	@Autowired
	private FreeBoardService service;
	private String SUCCESS_FORM = "/freeboard/list.do";
	private String VIEW_FORM = "/jsp/modify.jsp";
	
	// POST 메소드일 경우
	public void processSubmit (HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
		ModifyRequest modifyRequest = toModifyRequest(request);
		// 입력값 검증
		modifyRequest.validate();
		//서비스 호출
		service.modify(modifyRequest);
		
		// 포워딩 필요
		response.sendRedirect(request.getContextPath()+SUCCESS_FORM);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void processForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
		int number = toArticleNumber(request);
		
		// 읽은 횟수 증가는 안함
		ArticleData result =  service.read(number, false);
		request.setAttribute("article", result);
		forward(request, response, VIEW_FORM);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	private ModifyRequest toModifyRequest(HttpServletRequest request) {
		return new ModifyRequest((UserVo)request.getSession().getAttribute("user"), Integer.parseInt(request.getParameter("articleNumber")), request.getParameter("title"), request.getParameter("content"));
	}
	
	private int toArticleNumber(HttpServletRequest request) throws Exception {
		try {
		String page = request.getParameter("articleNumber");
		if (CommonUtil.isEmpty(page)) {
			return 1;
		} else {
			int pageNumber =  Integer.parseInt(page);
			return pageNumber;
		}
		}catch (NumberFormatException e) {
			e.printStackTrace();
			throw new Exception("글 번호가 숫자가 아닙니다");
		}
	}
}
