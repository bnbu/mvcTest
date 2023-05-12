package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class CloseHelper {
	public static void close(Connection conn) throws Exception {
		if (conn != null && !conn.isClosed()) conn.close(); 
	}
	public static void close(Statement stmt) throws Exception {
		if (stmt != null && !stmt.isClosed()) stmt.close();
	}
	public static void close(PreparedStatement pstmt) throws Exception {
		if (pstmt != null && !pstmt.isClosed()) pstmt.close();
	}
	public static void close(ResultSet rs) throws Exception {
		if (rs != null && !rs.isClosed()) rs.close();
	}
}
