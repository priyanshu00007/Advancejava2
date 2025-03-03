package DB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author madhvibera
 */
public class RegistrationServlet extends HttpServlet {

    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/JSP_DB", "root", "root");

            //PreparedStatement ps= con.prepareStatement("insert into members(first_name, last_name, email, uname, pass, regdate) values ('" + fname + "','" + lname + "','" + email + "','" + uname + "','" + pass + "', CURRENT_DATE)");
            
            PreparedStatement ps= con.prepareStatement("insert into members(first_name, last_name, email, uname, pass, regdate) values (?,?,?,?,?,?)");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, email);
            ps.setString(4, uname);
            ps.setString(5, pass);
            ps.setDate(6,getCurrentDate());

            int i = ps.executeUpdate();

            if (i > 0) {
               
                System.out.println("You are sucessfully registered");
                response.sendRedirect("index.html");
            }
        } catch (Exception se) {
            out.println(se);
        }

    }
}
