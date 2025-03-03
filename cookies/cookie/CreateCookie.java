import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CreateCookie extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Creating a cookie
        Cookie userCookie = new Cookie("username", "Priyanshu");
        userCookie.setMaxAge(60 * 60 * 24); // Cookie expires in 1 day
        response.addCookie(userCookie); // Sending cookie to the client

        out.println("<html><body>");
        out.println("<h3>Cookie Created: Username = Priyanshu</h3>");
        out.println("<a href='ReadCookie'>Read Cookie</a>");
        out.println("</body></html>");
    }
}
