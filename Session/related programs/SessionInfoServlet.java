import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SessionInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve current session
        HttpSession session = request.getSession(false); // false = don't create a new session if it doesn't exist

        if (session != null && session.getAttribute("user") != null) {
            String user = (String) session.getAttribute("user");
            out.println("<h3>Session Active: Welcome " + user + "</h3>");
            out.println("<a href='LogoutServlet'>Logout</a>");
        } else {
            out.println("<h3>No Active Session!</h3>");
        }
    }
}
