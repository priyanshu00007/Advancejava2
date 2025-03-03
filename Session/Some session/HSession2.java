import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HSession2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve existing session
        HttpSession hs = request.getSession(false);

        if (hs != null) {
            String n = (String) hs.getAttribute("s_id");
            out.println("<h3>Welcome, " + n + "!</h3>");
            out.println("<p><a href='HSession3'>Visit Again</a></p>");
        } else {
            out.println("<h3>Session Expired! Please login again.</h3>");
            response.sendRedirect("httpsession.html");
        }
    }
}
