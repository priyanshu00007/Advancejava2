import java.sql.*; import java.util.Scanner; public class InsertStudent { public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) { Class.forName("org.apache.derby.jdbc.ClientDriver");
    try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentDB;create=true", "root",
    "root")) { System.out.print("Enter ID: "); int id = scanner.nextInt(); scanner.nextLine();
    System.out.print("Enter Name: "); String name = scanner.nextLine();
    System.out.print("Enter Age: "); int age = scanner.nextInt(); scanner.nextLine();
    System.out.print("Enter Course: "); String course = scanner.nextLine();
    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO STUDENT VALUES (?, ?, ?, ?)");
    pstmt.setInt(1, id); pstmt.setString(2, name); pstmt.setInt(3, age); pstmt.setString(4, course);
    System.out.println(pstmt.executeUpdate() > 0 ? "Student inserted!" : "Insert failed!");
    } } catch (Exception e) { System.out.println("Error: " + e.getMessage()); } } }