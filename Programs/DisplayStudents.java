import java.sql.*;

public class DisplayStudents {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentDB;create=true", "root",
                "root");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT")) {
            while (rs.next())
                System.out.println(rs.getInt("ID") + " | " + rs.getString("NAME") + " | " + rs.getInt("AGE") + " | " +
                        rs.getString("COURSE"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}