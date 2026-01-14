package jdbc;


import java.sql.Statement; // 필요하면 추가
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcExample {
	Connection connection = null;
	Statement stmt = null;
	ResultSet rs = null;
	Scanner sc = new Scanner(System.in);
	public JdbcExample(Connection conn) {
	    this.connection = conn;
	}

	
	public void displayMenu() {
	System.out.println("---------------------");
	System.out.println("1. 자료입력");
	System.out.println("2. 자료삭제");
	System.out.println("3. 자료수정");
	System.out.println("원하는 작업 선택>>");
	}
	
	public void start() {
		int choice;
		do {
			displayMenu();
			choice = sc.nextInt();
			switch(choice) {
			case 1 :
				insertMenu();
				break;
				
			case 2:
				deleteMenu();
				break;
				
			case 3:
				updateMenu();
				break;
				
			default:
				System.out.println("번호를 잘못 입력하셨습니다.");
				
			}
		}while(choice !=5);
	}
	
	//insertMenu
	private void insertMenu() {
		try {
		System.out.println("이름 입력:");
		String name = sc.next();
		System.out.println("나이 입력:");
		int age = sc.nextInt();
		sc.nextLine();
		String sql = "INSERT INTO my (name, age) VALUES (?, ?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, age);

		int result = pstmt.executeUpdate();
		if (result > 0) {
		    System.out.println("자료 입력 성공!");
		} else {
		    System.out.println("자료 입력 실패!");
		}
		
	}catch(SQLException e) {
		System.out.println("오류 발생");
		e.printStackTrace();
	}
		
	}
		
		
		
//deleteMenu
	private void deleteMenu() {
		try {
			System.out.println("삭제할 이름 입력:");
			String name = sc.next();
			String sql = "DELETE FROM my WHERE name =?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			
			int result = pstmt.executeUpdate();
			if(result >0) {
				System.out.println(name +"님이 삭제되었습니다.");
			}else {
				System.out.println(name +"삭제할수없습니다.");
			}
			
		}catch(SQLException e) {
			System.out.println("삭제할 데이터가 없습니다.");
			e.printStackTrace();
		}
		
	}
	
//updateMenu
	private void updateMenu() {
		System.out.println("updateMenu");
	}

	public static void main(String[] args) {
		 String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@localhost:1521:xe";
	        String user = "test";
	        String password = "test";

	        try {
	            Class.forName(driver);
	            System.out.println("로딩 성공...");

	            Connection connection = DriverManager.getConnection(url, user, password);
	            System.out.println("DB 연결 성공...");

	            JdbcExample example = new JdbcExample(connection);
	            example.start();

	            connection.close();
	        } catch (Exception e) {
	            System.out.println("오류 발생...");
	            e.printStackTrace();
	        }
	    }
	}
