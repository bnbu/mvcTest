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
}
