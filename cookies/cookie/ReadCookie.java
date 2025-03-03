import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ReadCookie extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Reading cookies from the request
        Cookie[] cookies = request.getCookies();
        
        out.println("<html><body>");
        if (cookies != null) {
            out.println("<h3>Cookies Found:</h3>");
            for (Cookie cookie : cookies) {
                out.println("<p>" + cookie.getName() + " = " + cookie.getValue() + "</p>");
            }
        } else {
            out.println("<h3>No cookies found!</h3>");
        }
        out.println("</body></html>");
    }
}
