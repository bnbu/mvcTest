package controller;

import java.sql.*;
import java.util.*;

import util.ConnectionHelper;

import java.io.*;
public class GogakController {
	static Connection conn;
	static Statement stmt;
	static PreparedStatement pstmt;
	static ResultSet rs;
	static BufferedReader br;
	
	static void connect() throws Exception {
		conn = ConnectionHelper.getConnection();
		stmt = conn.createStatement();
		conn.setAutoCommit(false);
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	static void menu() {
		
	}
	
	static void delete(String className) throws Exception {
		String sql = "DELETE FROM " + className + " WHERE GNO = ?";
		pstmt = conn.prepareStatement(sql);
		System.out.print("삭제할 사람의 GNO : ");
		pstmt.setString(1, br.readLine());
		pstmt.executeUpdate();
		
		System.out.print("삭제 완료");
	}
	
	public static void selectAll(String className) throws SQLException {
		rs = stmt.executeQuery("Select * from " + className); // class name <- gogak 고정
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		System.out.println("모든 회원 정보를 출력합니다");
		System.out.println();
		while (rs.next()) {
			for (int i = 1; i <= count; i++) {
				switch (rsmd.getColumnType(i)) {
				case Types.NUMERIC:
				case Types.CHAR:
					System.out.println(rsmd.getColumnLabel(i) + ":" + rs.getString(i) + " ");
					break;
				default:
					System.out.println(rsmd.getColumnLabel(i) + ":" + rs.getString(i) + " ");
					break;
				}// switch end
			} // for end
			System.out.println();
		} // while end
	}
}
