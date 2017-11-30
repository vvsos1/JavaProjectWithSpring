package org.dimigo.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import nettyInActionWebSocket.HttpRequestHandler;

/**
 * <pre>
 * org.dimigo.service
 * 	 |_ FileService
 *
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 30.
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class FileService {
	public static final String FILE_ROOT = HttpRequestHandler.FILE_ROOT;
	
	public List<String> listUploader() throws Exception {
		try {
		List<String> result = new ArrayList<>();
		
		File root = new File(FILE_ROOT);
		File[] files = root.listFiles();
		
		for(File file : files) {
			if (file.isDirectory() && file.listFiles().length != 0 )
				result.add(file.getName());
		}
		
		return result;
		} catch (Exception e) {
			throw new Exception("파일 업로더 리스트를 가져오는데 실패했습니다",e);
		}
	}
	
	public List<String> listFile(String uploader) throws Exception {

		List<String> result = new ArrayList<>();
		
		File root = new File(FILE_ROOT+"/"+uploader);
		if (!root.exists() || root.listFiles() == null) {
			throw new Exception("없는 업로더입니다");
		}
		File[] files = root.listFiles();
		
		for(File file : files) {
			if (file.isFile())
				result.add(file.getName());
		}
		
		return result;
	}
}
