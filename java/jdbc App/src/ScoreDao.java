

import java.sql.*;
import java.util.Vector;

public class ScoreDao {


    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    private static final String USER = "Scott";
    private static final String PASS = "tiger";

    PreparedStatement ps = null;
    ResultSet rs = null;

    public Connection getConn() {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    // Insert score into the database
    public int insertScore(ScoreDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            con = getConn();
            String sql = "INSERT INTO score (name, kor, eng, mat, tot, ave) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setInt(2, dto.getKor());
            ps.setInt(3, dto.getEng());
            ps.setInt(4, dto.getMat());
            ps.setInt(5, dto.getTot());
            ps.setInt(6, dto.getAve());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // Update score for a student
    public int updateScore(ScoreDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            con = getConn();
            String sql = "UPDATE score SET kor = ?, eng = ?, mat = ?, tot = ?, ave = ? WHERE name = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, dto.getKor());
            ps.setInt(2, dto.getEng());
            ps.setInt(3, dto.getMat());
            ps.setInt(4, dto.getTot());
            ps.setInt(5, dto.getAve());
            ps.setString(6, dto.getName());
            result = ps.executeUpdate();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // Delete score for a student
    public int deleteScore(ScoreDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            con = getConn();
            String sql = "DELETE FROM score WHERE name = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getName());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // Select all scores
    public Vector getScore() {
        Vector data = new Vector<>();
        Connection con = null;
        Statement ps = null;
        ResultSet rs = null;

        try {
            con = getConn();
            String sql = "SELECT * FROM score ORDER BY name ASC";
            ps = con.createStatement();
            rs = ps.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                int kor = rs.getInt("kor");
                int eng = rs.getInt("eng");
                int mat = rs.getInt("mat");
                int tot = rs.getInt("tot");
                int ave = rs.getInt("ave");

                Vector<Object> row = new Vector<>();
                row.add(name);
                row.add(kor);
                row.add(eng);
                row.add(mat);
                row.add(tot);
                row.add(ave);
                data.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

        return data;
    }
}
