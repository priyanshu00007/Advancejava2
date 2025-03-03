import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CookieDeleteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Delete the cookie by setting its max age to 0
        Cookie cookie = new Cookie("username", "");
        cookie.setMaxAge(0); // Marks cookie for deletion
        response.addCookie(cookie);

        out.println("<h3>Cookie Deleted Successfully!</h3>");
    }
}
