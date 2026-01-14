package jdbc;

import java.sql.*;
import java.util.Scanner;

public class JDBCUtill {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private Scanner scan = new Scanner(System.in);

    
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로딩 완료...");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패...");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "test",
                    "test");
        } catch (SQLException e) {
            System.out.println("DB 연결 실패...");
            e.printStackTrace();
            return null;
        }
    }

    // 자원 해제 메서드
    public static void disconnect(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
        try { if (rs != null) rs.close(); } catch (SQLException e) { }
        try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { }
        try { if (stmt != null) stmt.close(); } catch (SQLException e) { }
        try { if (conn != null) conn.close(); } catch (SQLException e) { }
    }

    // 메뉴 출력
    public void displayMenu() {
        System.out.println();
        System.out.println("---------------");
        System.out.println("=== 작업 선택 ===");
        System.out.println("1. 자료 입력");
        System.out.println("2. 자료 삭제");
        System.out.println("3. 자료 수정");
        System.out.println("4. 전체 자료 출력");
        System.out.println("5. 작업 끝");
        System.out.println("----------------");
        System.out.print("원하는 작업 선택 >> ");
    }

    // 회원 존재 여부 확인
    private boolean getMember(String memId) {
        boolean chk = false;

        try {
            conn = getConnection();
            String sql = "SELECT COUNT(*) cnt FROM mymember WHERE mem_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("cnt");
                chk = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect(conn, stmt, pstmt, rs);
        }

        return chk;
    }

    // 프로그램 시작
    public void start() {
        int choice;
        do {
            displayMenu();
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    insertMember();
                    break;
                case 2:
                    deleteMember();
                    break;
                case 3:
                    updateMember();
                    break;
                case 4:
                    displayMemberAll();
                    break;
                case 5:
                    System.out.println("작업을 마칩니다.");
                    break;
                default:
                    System.out.println("번호를 잘못 입력하였습니다. 다시 입력하여주세요");
            }
        } while (choice != 5);
    }

    // 회원 삭제
    private void deleteMember() {
        System.out.println();
        System.out.println("삭제할 회원의 정보를 입력하세요");
        System.out.print("회원 ID >> ");
        String memId = scan.next();

        try {
            conn = getConnection();
            String sql = "DELETE FROM mymember WHERE mem_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);

            int cnt = pstmt.executeUpdate();

            if (cnt > 0) {
                System.out.println(memId + "님의 정보 삭제 완료...");
            } else {
                System.out.println(memId + "님의 정보 삭제 실패...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect(conn, stmt, pstmt, rs);
        }
    }

    // 회원 추가
    private void insertMember() {
        boolean chk;
        String memId;

        do {
            System.out.println();
            System.out.println("추가할 회원의 정보를 입력하세요");
            System.out.print("회원 ID >> ");
            memId = scan.next();

            chk = getMember(memId);

            if (chk) {
                System.out.println("회원 ID가 " + memId + "인 회원은 이미 존재합니다.");
                System.out.println("다시 입력해주세요..");
            }
        } while (chk);

        System.out.print("회원 이름 >> ");
        String memName = scan.next();

        System.out.print("전화번호 >> ");
        String memTel = scan.next();

        scan.nextLine(); // 입력 버퍼 비우기
        System.out.print("주소 >> ");
        String memAddr = scan.nextLine();

        try {
            conn = getConnection();
            String sql = "INSERT INTO mymember (mem_id, mem_name, mem_tel, mem_addr) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);
            pstmt.setString(2, memName);
            pstmt.setString(3, memTel);
            pstmt.setString(4, memAddr);

            int cnt = pstmt.executeUpdate();

            if (cnt > 0) {
                System.out.println(memId + "님의 정보 추가 완료!");
            } else {
                System.out.println("정보 추가 실패...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect(conn, stmt, pstmt, rs);
        }
    }

    // 회원 수정
    private void updateMember() {
        boolean chk;
        String memId;

        do {
            System.out.println();
            System.out.println("수정할 회원의 정보를 입력하세요");
            System.out.print("회원 ID >> ");
            memId = scan.next();

            chk = getMember(memId);

            if (!chk) {
                System.out.println("회원 ID가 " + memId + "인 회원은 없습니다.");
                System.out.println("다시 입력해주세요.");
            }
        } while (!chk);

        System.out.print("새로운 회원 이름 >> ");
        String memName = scan.next();

        System.out.print("새로운 전화번호 >> ");
        String memTel = scan.next();

        scan.nextLine(); // 입력 버퍼 비우기
        System.out.print("새로운 주소 >> ");
        String memAddr = scan.nextLine();

        try {
            conn = getConnection();
            String sql = "UPDATE mymember SET mem_name = ?, mem_tel = ?, mem_addr = ? WHERE mem_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memName);
            pstmt.setString(2, memTel);
            pstmt.setString(3, memAddr);
            pstmt.setString(4, memId);

            int cnt = pstmt.executeUpdate();

            if (cnt > 0) {
                System.out.println(memId + "님의 정보 수정 완료!");
            } else {
                System.out.println(memId + "님의 정보 수정 실패...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect(conn, stmt, pstmt, rs);
        }
    }

    // 전체 회원 출력
    private void displayMemberAll() {
        System.out.println();
        System.out.println("===================================");
        System.out.println("ID\t이름\t전화번호\t주소");
        System.out.println("===================================");

        try {
            conn = getConnection();
            String sql = "SELECT * FROM mymember";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String memId = rs.getString("mem_id");
                String memName = rs.getString("mem_name");
                String memTel = rs.getString("mem_tel");
                String memAddr = rs.getString("mem_addr");

                System.out.println(memId + "\t" + memName + "\t" + memTel + "\t" + memAddr);
            }

            System.out.println("===================================");
            System.out.println("출력 작업 끝 ...");

        } catch (SQLException e) {
            System.out.println("가져오기 실패...");
            e.printStackTrace();
        } finally {
            disconnect(conn, stmt, pstmt, rs);
        }
    }

    public static void main(String[] args) {
        JDBCUtill app = new JDBCUtill();
        app.start();
    }
}
