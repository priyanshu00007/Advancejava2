import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Invalidate session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            out.println("<h3>Session Invalidated. Logged Out.</h3>");
        } else {
            out.println("<h3>No Active Session to Logout!</h3>");
        }
    }
}
