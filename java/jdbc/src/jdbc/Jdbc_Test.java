package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc_Test {

    public static void main(String[] args) {
        
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String userid = "test";
        String passwd = "test";
        
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            String sql = "";
            Scanner scan = new Scanner(System.in);
            System.out.println("매출 조회 메뉴 - [ 매출 일자순 : 1, 상품별 매출순 : 2] :");
            int menu = scan.nextInt();
            if(menu == 1) {
                sql = "SELECT TO_CHAR(O.ODATA, 'YYYY-MM-DD') AS 영업일,\r\n"
                		+ "       SUM(O.QUANTITY * P.PRICE) AS 매출\r\n"
                		+ "FROM D7_ORDER O,\r\n"
                		+ "     D7_PRODUCT P\r\n"
                		+ "WHERE O.PID = P.PID\r\n"
                		+ "GROUP BY O.ODATA\r\n"
                		+ "ORDER BY 1";
            } else if(menu == 2) {
                sql = "SELECT PNAME 상품명, SUM(O.QUANTITY * P.PRICE) 매출 FROM D7_ORDER O, D7_PRODUCT P\r\n"
                		+ "GROUP BY PNAME\r\n"
                		+ "ORDER BY 2 DESC\r\n";
         
            }
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            System.out.println("-------------------------------------");
            System.out.println(((menu==1)?"영업일:":"상품명") +"\t\t\t매출");
            System.out.println("-------------------------------------");
            while(rs.next()) {
            	System.out.println(rs.getString(1) + "\t\t" + rs.getString(2));
            }
            System.out.println("-------------------------------------");
        }catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }catch (SQLException e) {
        	e.printStackTrace();
        }finally {
        	try {
        		if(rs != null)
        			rs.close();
        		if(pstmt != null)
        			pstmt.close();
        		if( con != null)
        			con.close();
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
        }
    }
}


