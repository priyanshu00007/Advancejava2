import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HSession2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false); // Get existing session

        // Retrieve cookie
        Cookie[] cookies = request.getCookies();
        String cookieValue = "No Cookie Found";

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    cookieValue = cookie.getValue();
                }
            }
        }

        if (session != null) {
            String n = (String) session.getAttribute("s_id");
            out.println("<h3>Welcome, " + n + "!</h3>");
            out.println("<p>Cookie Value: " + cookieValue + "</p>");
            out.println("<a href='HSession3'>Visit Again</a>");
        } else {
            out.println("<h3>Session Expired! Please login again.</h3>");
            response.sendRedirect("httpsession.html");
        }
    }
}
