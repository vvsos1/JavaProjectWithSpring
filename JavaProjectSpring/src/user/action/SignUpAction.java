package user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.action.IAction;
import org.dimigo.service.UserService;
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
public class SignUpAction implements IAction {
	@Autowired
	private UserService service;

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject res = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String grade = request.getParameter("grade");
			String classroom = request.getParameter("classroom");
			String number = request.getParameter("number");
			String name = request.getParameter("name");


			UserVo vo = new UserVo();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setGrade(grade);
			vo.setClassroom(classroom);
			vo.setName(name);
			vo.setNumber(number);
			
			vo.validate();

			// Service 호출
			service.signup(vo);
			
			System.out.println("회원가입 성공 : "+vo);
			res.put("result", "success");
			res.put("userName", vo.getName());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 실패");
			res.put("result", "fail");
			res.put("msg", e.getMessage());
		} finally {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(res.toJSONString());
		}
	}
}
