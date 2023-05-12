package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    private static Connection conn;

    private ConnectionHelper() {
    }

    public static Connection getConnection(String dsn) {
        try {
            if (dsn.equalsIgnoreCase("mysql")) {
                Class.forName("org.gjt.mm.mysql.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB명 ", "song", "Thdrltjr12**");
            } else if (dsn.equalsIgnoreCase("oracle")) {
                Class.forName("oracle.jdbc.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@edudb_high?TNS_ADMIN=./src/main/lib/Wallet_edudb", "song",
                        "Thdrltjr12**");
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
