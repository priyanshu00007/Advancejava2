// Required imports for database connectivity and user input
import java.sql.*;
import java.util.Scanner;

public class InsertStudent {
    public static void main(String[] args) {
        // Create Scanner object with try-with-resources to auto-close the resource
        try (Scanner scanner = new Scanner(System.in)) {
            // Load the Derby JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // Establish database connection with try-with-resources
            // URL format: jdbc:derby://host:port/databaseName
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentDB;create=true",
                    "root",
                    "root")) {
                
                // Get student details from user input
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline
                
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                
                System.out.print("Enter Age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline
                
                System.out.print("Enter Course: ");
                String course = scanner.nextLine();

                // Prepare SQL statement with placeholders (?) to prevent SQL injection
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO STUDENT VALUES (?, ?, ?, ?)");
                
                // Set values for the prepared statement
                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setInt(3, age);
                pstmt.setString(4, course);

                // Execute the insert statement and check if it was successful
                // executeUpdate() returns the number of rows affected
                System.out.println(pstmt.executeUpdate() > 0 ? "Student inserted!" : "Insert failed!");
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during execution
            System.out.println("Error: " + e.getMessage());
        }
    }
}