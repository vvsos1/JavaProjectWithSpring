package freeboard.vo;

import org.dimigo.exception.InvalidArguementException;
import org.dimigo.exception.PermissionDeniedException;
import org.dimigo.util.CommonUtil;

import user.vo.UserVo;

/**
 * <pre>
 * org.dimigo.vo |_ FreeBoardWriteRequest
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 18.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class WriteRequest {
	private UserVo requester;
	private String title;
	private String content;

	public WriteRequest(UserVo requester, String title, String content) {
		super();
		this.requester = requester;
		this.title = title;
		this.content = content;
	}

	public UserVo getRequester() {
		return requester;
	}

	public void setRequester(UserVo requester) {
		this.requester = requester;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void validate() throws PermissionDeniedException, InvalidArguementException {
		if (requester == null) {
			throw new PermissionDeniedException("로그인하지 않고는 글을 쓸 수 없습니다");
		}
		if (CommonUtil.isEmpty(title)) {
			throw new InvalidArguementException("글의 제목이 없습니다");
		}
		if (CommonUtil.isEmpty(content)) {
			throw new InvalidArguementException("글의 내용이 없습니다");
		}
	}

}
