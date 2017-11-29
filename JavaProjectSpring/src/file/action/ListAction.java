package file.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.action.IAction;
import org.dimigo.service.FileService;
import org.dimigo.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * file.action
 * 	 |_ ListAction
 *
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 30.
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class ListAction implements IAction{
	@Autowired
	FileService service;
	@Override
	public void processForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uploader = request.getParameter("uploader");
		
		if (CommonUtil.isEmpty(uploader)) {
			showUploaderList(request, response);
		} else {
			showFileList(request, response);
		}
	}

	private void showFileList(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void showUploaderList(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
