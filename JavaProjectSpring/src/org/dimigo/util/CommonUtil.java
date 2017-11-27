package org.dimigo.util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * <pre>
 * org.dimigo.util |_ CommonUtil
 *
 * 1. 개요 : 2. 작성일 : 2017. 10. 31.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class CommonUtil {

	public static boolean isEmpty(String s) {
		return s == null || "".equals(s.trim());
	}

	public static void close(AutoCloseable obj) { // 자원을 null 체크한 뒤 close
		if (obj != null) {
			try {
				obj.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void rollback(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
