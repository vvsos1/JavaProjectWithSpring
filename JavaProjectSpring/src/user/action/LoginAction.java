package user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.action.IAction;
import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtil;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import user.vo.UserVo;

/**
 * <pre>
 * org.dimigo.action |_ LoginAction
 *
 * 1. 개요 : 2. 작성일 : 2017. 10. 31.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class LoginAction implements IAction {
	@Autowired
	private UserService service;
	// 입력값 검증
	private void validate(String id, String pwd) throws Exception {
		if (CommonUtil.isEmpty(id))
			throw new Exception("아이디를 입력하세요.");
		if (CommonUtil.isEmpty(pwd))
			throw new Exception("비밀번호를 입력하세요.");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {	// ajax 방식
		JSONObject res = new JSONObject();
		try {
			// 1. 입력값 추출
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			System.out.printf("id : %s, pwd : %s\n", id, pwd);

			// 2. 입력값 검증
			validate(id, pwd);

			UserVo vo = new UserVo();
			vo.setId(id);
			vo.setPwd(pwd);
			// 3. Service 호출
			UserVo result = service.login(vo);

			// 세션에 사용자 정보를 생성해서 담기
			HttpSession session = request.getSession();

			session.setAttribute("user", result);
			
			res.put("result", "success");

		} catch (Exception e) { // validate에서 발생한 입력값 검증 Exception 또는
								// UserService에서 발생한 로그인 실패 Exception을 받음
			e.printStackTrace();
			res.put("result", "fail");
			res.put("msg", e.getMessage());	// 로그인에 실패한 경우에만 msg에 메세지 담음
		} finally {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(res.toJSONString());
		}
	}

}
