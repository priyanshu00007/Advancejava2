import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Valid extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;

        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");
        String session = request.getParameter("session_id");

        if ("java".equals(login) && "servlet".equals(pwd)) {
            // Forward request to Welcome servlet if login is successful
            rd = request.getRequestDispatcher("Welcome");
            rd.forward(request, response);
        } else {
            // Display error message and reload login page
            out.println("<h1 style='color:red;'>Incorrect Login ID / Password</h1>");
            rd = request.getRequestDispatcher("/login.html");
            rd.include(request, response);
        }
    }
}
