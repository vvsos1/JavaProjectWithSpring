package user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.action.IAction;

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
public class LogoutAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 세션에 담긴 사용자 정보를 삭제
		HttpSession session = request.getSession();
		// session.removeAttribute("user");
		session.invalidate(); // 현재 접속중인 세션 자체를 삭제하고 재발급
		
		response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
	}

}
