import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Cookie2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve cookies from the request
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            out.println("<h3>Existing Cookies:</h3>");
            for (Cookie c : cookies) {
                out.println("<p>Cookie Name: " + c.getName() +
                        " | Cookie Value: " + c.getValue() + "</p>");
            }
        } else {
            out.println("<h3>No Cookies Found!</h3>");
        }

        // Add a new cookie
        Cookie newCookie = new Cookie("c2", "054");
        response.addCookie(newCookie);

        // Link to next page
        String path = "/Session/Cookie3";
        out.println("<p><a href='" + path + "'>Next Page</a></p>");
    }
}
