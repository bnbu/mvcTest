package controller;

import java.sql.*;
import java.util.*;

import model.GogakVO;
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
    
    private static void insert(String name) throws IOException {
//        selectAll(name);
        
        System.out.println("고객번호를 입력하세요"); int gno = Integer.parseInt(br.readLine());
        System.out.println("고객명을 입력하세요"); String gname = br.readLine();
        System.out.println("주민번호를 입력하세요"); 
        String jumin = br.readLine();
        System.out.println("포인트를 입력하세요"); int point = Integer.parseInt(br.readLine());

        try {
            pstmt = conn.prepareStatement("INSERT INTO " + name + " VALUES(?,?,?,?)");
            pstmt.setInt(1, gno);
            pstmt.setString(2, gname);
            pstmt.setString(3, jumin);
            pstmt.setInt(4, point);
            int result = pstmt.executeUpdate();
            System.out.println(result + "개의 데이터를 삽입했습니다.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

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
