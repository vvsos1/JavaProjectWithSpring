package file.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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

	private void showFileList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
		List<String> result = service.listFile(request.getParameter("uploader"));
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("/jsp/fileList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/jsp/uploaderList.jsp").forward(request, response);
		}
	}

	private void showUploaderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			
			List<String> result = service.listUploader();
			
			request.setAttribute("result", result);
			request.getRequestDispatcher("/jsp/uploaderList.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
			}
		
	}
}
