package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionHelper {
	private static Connection conn;

	private ConnectionHelper() {
	}

	public static Connection getConnection(String dsn) {
		Properties properties = new Properties();
		Reader reader;
		try {
			reader = new FileReader("./src/main/lib/"+dsn+".properties"); 
			properties.load(reader);
		} catch (FileNotFoundException e1) {
			System.out.println("예외: 지정한 파일을 찾을수없습니다 :" + e1.getMessage());
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String driverName = properties.getProperty("driver"); 
		String url = properties.getProperty("url"); 
		String user = properties.getProperty("user");
		String pwd = properties.getProperty("password");
		try {
			if (dsn.equalsIgnoreCase("mysql")) {
				Class.forName(driverName);
				conn = DriverManager.getConnection(url, user, pwd);
			} else if (dsn.equalsIgnoreCase("oracle")) {
				Class.forName(driverName);
				conn = DriverManager.getConnection(url, user, pwd);
			}
			System.out.println("연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return conn;
		}
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
