package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import model.GogakVO;
import util.CloseHelper;
import util.ConnectionHelper;
public class GogakController {
    static Connection conn;
    static Statement stmt;
    static PreparedStatement pstmt;
    static ResultSet rs;
    static BufferedReader br;
    
    public static void connect() throws Exception {
        conn = ConnectionHelper.getConnection("oracle");
        stmt = conn.createStatement();
        conn.setAutoCommit(false);
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public static void menu() throws Exception {
        GogakVO vo = new GogakVO();
        
        while( true ) {
            System.out.println();
            ConnectionHelper.menuHelp();
            
            switch ( Integer.parseInt(br.readLine()) ) {
            case 1: selectAll(vo.getClassName()); break;
            case 2: insert(vo.getClassName()); break;
            case 3: update(vo.getClassName()); break;
            case 4: delete(vo.getClassName()); break;
//            case 5: SelectWhere(vo.getClassName()); break;
            case 0: close(); System.out.println("프로그램을 종료합니다.");
            System.exit(0); break;
            
            } // switch end
        } // while end
    } // menu end
  
    public static void close() throws Exception {
      CloseHelper.close(conn);
      CloseHelper.close(stmt);
      CloseHelper.close(pstmt);
      CloseHelper.close(rs);
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
  
    private static void update(String className) throws IOException {

      System.out.println("수정할 데이터의 번호를 입력하세요(gno : 숫자8자리)");
      String gno = br.readLine();
      System.out.println("수정할 칼럼명을 입럭하세요 (gno, gname, jumin, point)");
      String ColumName = "";
      while ( true ) {
        ColumName = br.readLine();
        if ( ColumName.equalsIgnoreCase("GNO")
            || ColumName.equalsIgnoreCase("GNAME")
            || ColumName.equalsIgnoreCase("JUMIN")
            || ColumName.equalsIgnoreCase("POINT") ) break;
        System.out.println("다시 입력해주세요.");
      }
      System.out.println("수정할 데이터 값을 입럭하세요.");
      String UpdateInput = br.readLine();

      try {
        pstmt = conn.prepareStatement("UPDATE " + className
            + " SET " + ColumName + " = ? WHERE GNO = ?"); // 반환값 있는 경우
        pstmt.setString(1, UpdateInput);
        pstmt.setString(2, gno);

        int result = pstmt.executeUpdate();
        System.out.println(result + "개 데이터가 수정되었습니다.");

      } catch (Exception e) { e.printStackTrace(); }
    }
    
    static void delete(String className) throws Exception {
      pstmt = conn.prepareStatement("DELETE FROM " + className + " WHERE GNO = ?");
      System.out.print("삭제할 사람의 GNO : "); String gno = br.readLine();
      pstmt.setString(1, gno);
      pstmt.executeUpdate();
      conn.commit();
      System.out.println("삭제 완료");
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
