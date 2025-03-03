import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class URLReceiverServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve session ID from URL
        String sessionId = request.getParameter("s_id");

        out.println("<h3>Received Session ID via URL: " + sessionId + "</h3>");
    }
}
