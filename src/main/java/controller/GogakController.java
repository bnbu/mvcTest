package controller;
import java.sql.*;
import java.util.*;

import util.CloseHelper;
import util.ConnectionHelper;

import java.io.*;
public class GogakController {
	static Connection conn;
	static Statement stmt;
	static PreparedStatement pstmt;
	static ResultSet rs;
	static BufferedReader br;
	
	public static void connect() throws Exception {
		conn = ConnectionHelper.getConnection();
		stmt = conn.createStatement();
		conn.setAutoCommit(false);
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	public static void close() throws Exception {
		CloseHelper.close(conn);
		CloseHelper.close(stmt);
		CloseHelper.close(pstmt);
		CloseHelper.close(rs);
	}
	
	public static void menu() {
		
	}
	
	static void delete(String className) throws Exception {
		pstmt = conn.prepareStatement("DELETE FROM " + className + " WHERE GNO = ?");
		System.out.print("삭제할 사람의 GNO : "); String gno = br.readLine();
		pstmt.setString(1, gno);
		pstmt.executeUpdate();
		conn.commit();
		System.out.println("삭제 완료");
	}
}
