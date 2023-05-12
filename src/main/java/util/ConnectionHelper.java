package util;

import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.*;
// ConnectionHelper의 문제
// 매번 드라이버 로드 -> connection 생성
public class ConnectionHelper {
	private static Connection conn;
	private ConnectionHelper() {	}
	public static Connection getConnection() throws Exception {
		if (conn != null) return conn;
		Properties properties = new Properties();
        Reader reader = new FileReader("./src/main/lib/oracle.properties"); // 읽어올 파일 지정
        properties.load(reader);
        
        String driverName = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("password");
        Class.forName(driverName);
        return conn = DriverManager.getConnection(url, user, pwd);
	}
	
	public static void menuHelp() {
			
			System.out.println("\n=-=-=-=-=-=-=-= 고객 관리 =-=-=-=-=-=-=-=");
			System.out.println("\t 1. 전 체 보 기");
			System.out.println("\t 2. 레코드 추가");
			System.out.println("\t 3. 레코드 수정");
			System.out.println("\t 4. 레코드 삭제");
			System.out.println("\t 5. 조건에 의한 검색(ex> gno)");
			System.out.println("\t 0. 프로그램 종료");
			System.out.println("\t >> 원하는 메뉴 선택하세요.");
		
	}
}
