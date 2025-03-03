import java.sql.*;
import java.util.Scanner;

public class UpdateStudent {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentDB;create=true",
                    "root", "root")) {
                System.out.print("Enter Student ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("New Name: ");
                String name = scanner.nextLine();
                System.out.print("New Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("New Course: ");
                String course = scanner.nextLine();
                PreparedStatement pstmt = conn
                        .prepareStatement("UPDATE STUDENT SET NAME=?, AGE=?, COURSE=? WHERE ID=?");
                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, course);
                pstmt.setInt(4, id);
                System.out.println(pstmt.executeUpdate() > 0 ? "Student updated!" : " No record found!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}