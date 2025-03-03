import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DeleteCookie extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0); // Setting expiry to 0 deletes it
                response.addCookie(cookie);
            }
        }

        out.println("<html><body>");
        out.println("<h3>All Cookies Deleted</h3>");
        out.println("</body></html>");
    }
}
