import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Cookie1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve login credentials from request
        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");

        // Validate credentials (Hardcoded for demo)
        if (login.equals("java") && pwd.equals("servlet")) {
            // Create a cookie
            Cookie c = new Cookie("c1", login);
            response.addCookie(c); // Add cookie to response

            out.println("<h3>Cookie Created: " + c.getName() + "</h3>");
            String path = "/Session/Cookie2";
            out.println("<p><a href='" + path + "'>Next Page</a></p>");
        } else {
            // Redirect to login page if credentials are wrong
            response.sendRedirect("cookie.html");
        }
    }
}
