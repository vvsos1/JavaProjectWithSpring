package user.vo;

import org.dimigo.exception.InvalidArguementException;
import org.dimigo.util.CommonUtil;

/**
 * <pre>
 * user.vo |_ ModifyRequest
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 26.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class ModifyRequest {
	private UserVo sessionUser;
	private String oldPwd;
	private UserVo newInfo;

	public ModifyRequest(UserVo sessionUser, String oldPwd, UserVo newInfo) {
		super();
		this.sessionUser = sessionUser;
		this.oldPwd = oldPwd;
		this.newInfo = newInfo;
	}

	public UserVo getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(UserVo sessionUser) {
		this.sessionUser = sessionUser;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public UserVo getNewInfo() {
		return newInfo;
	}

	public void setNewInfo(UserVo newInfo) {
		this.newInfo = newInfo;
	}

	public void validate() throws InvalidArguementException {
		newInfo.validate();
		if (!sessionUser.getId().equals(newInfo.getId())) {
			throw new InvalidArguementException("아이디는 변경할 수 없습니다");
		}
		if (CommonUtil.isEmpty(oldPwd)) {
			throw new InvalidArguementException("현재 비밀번호를 입력하세요");
		}
		if (!sessionUser.getPwd().equals(oldPwd)) {
			throw new InvalidArguementException("현재 비밀번호가 틀립니다");
		}
	}

}
