package user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.action.IAction;
import org.dimigo.exception.InvalidArguementException;
import org.dimigo.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import user.vo.ModifyRequest;
import user.vo.UserVo;

/**
 * <pre>
 * user.action
 * 	 |_ ModifyAction
 *
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 26.
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class ModifyAction implements IAction{
	@Autowired
	private UserService service;
	@SuppressWarnings("unchecked")
	@Override
	public void processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject res = new JSONObject();
		try {
		request.setCharacterEncoding("utf-8");
		ModifyRequest modifyRequest = toModifyRequest(request);
		
		modifyRequest.validate();
		
		UserVo result = service.modify(modifyRequest);
		
		// 회원정보가 바뀌였으므로 세션의 유저정보를 업데이트
		request.getSession().setAttribute("user", result);
		
		res.put("result", "success");
		} catch (InvalidArguementException e) {
			e.printStackTrace();
			res.put("result", "fail");
			res.put("msg", e.getMessage());	// 로그인에 실패한 경우에만 msg에 메세지 담음
		} finally {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(res.toJSONString());
		}
	}

	private ModifyRequest toModifyRequest(HttpServletRequest request) {
		UserVo sessionUser = (UserVo) request.getSession().getAttribute("user");
		String oldPwd = request.getParameter("oldPwd");
		UserVo newInfo = new UserVo(request.getParameter("id"), request.getParameter("newPwd"), request.getParameter("grade"), request.getParameter("classroom"), request.getParameter("number"), request.getParameter("name"));
		System.out.println(newInfo);
		
		return new ModifyRequest(sessionUser, oldPwd, newInfo);
	}

}
