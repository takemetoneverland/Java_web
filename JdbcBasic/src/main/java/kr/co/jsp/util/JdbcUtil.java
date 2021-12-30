package kr.co.jsp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {

	public static void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt != null)
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("close 과정에서 에러 발생!");
			}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null)
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("close 과정에서 에러 발생!");
			}
	}
	
}
