import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CookieReaderServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve all cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            out.println("<h3>Cookies Found:</h3>");
            for (Cookie c : cookies) {
                out.println("<p>" + c.getName() + " = " + c.getValue() + "</p>");
            }
        } else {
            out.println("<h3>No Cookies Found!</h3>");
        }
    }
}
