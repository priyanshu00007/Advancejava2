import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class URLRewritingServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Hardcoded session ID for demo
        String url = "URLReceiverServlet?s_id=054";

        out.println("<a href='" + url + "'>Go to Next Page (URL Rewriting)</a>");
    }
}
