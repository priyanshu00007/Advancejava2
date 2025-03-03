import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HSession4 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
            out.println("<h3>Session Invalidated Successfully</h3>");
        } else {
            out.println("<h3>No Active Session Found</h3>");
        }

        // Delete the cookie
        Cookie userCookie = new Cookie("user", "");
        userCookie.setMaxAge(0); // Expire immediately
        response.addCookie(userCookie);

        // Provide logout button
        out.println("<form action='/Session/httpsession.html'>");
        out.println("<p><input type='submit' value='Logout'></p></form>");
    }
}
