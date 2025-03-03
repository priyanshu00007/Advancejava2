import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Cookie3 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve all cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            out.println("<h3>All Stored Cookies:</h3>");
            for (Cookie c : cookies) {
                out.println("<p>Cookie Name: " + c.getName() +
                        " | Cookie Value: " + c.getValue() + "</p>");
            }
        } else {
            out.println("<h3>No Cookies Available!</h3>");
        }
    }
}
