package file.action;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.dimigo.action.IAction;

/**
 * <pre>
 * file.action
 * 	 |_ UploadAction
 *
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 29.
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class UploadAction implements IAction{
	@Override
	public void processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String contentType = request.getContentType();
		System.out.println(contentType);
		if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
			printPartInfo(request, response);
		} else {
			System.out.println("multipart가 아님");
		}
	}
	private void printPartInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Collection<Part> parts = request.getParts();
		for(Part part : parts) {
			System.out.println("name : "+part.getName());
			System.out.println("contentType : "+part.getContentType());
		}
	}
	@Override
	public void processForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.sendError(404);
	}
}
