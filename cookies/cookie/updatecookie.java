import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UpdateCookie extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    cookie.setValue("UpdatedUser"); // Updating value
                    response.addCookie(cookie); // Sending updated cookie
                    break;
                }
            }
        }

        out.println("<html><body>");
        out.println("<h3>Cookie Updated: Username = UpdatedUser</h3>");
        out.println("<a href='ReadCookie'>Check Updated Cookie</a>");
        out.println("</body></html>");
    }
}
