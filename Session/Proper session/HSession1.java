import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HSession1 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String login = request.getParameter("login");

        if (login.equals("java")) {
            // Create a session and store login info
            HttpSession session = request.getSession();
            session.setAttribute("s_id", login);

            // Set session timeout to 10 minutes (600 seconds)
            session.setMaxInactiveInterval(10 * 60);

            // Create a cookie with login info, expires in 10 minutes
            Cookie userCookie = new Cookie("user", login);
            userCookie.setMaxAge(10 * 60); // 10 minutes
            response.addCookie(userCookie);

            out.println("<h3>Session & Cookie Created</h3>");
            out.println("<a href='HSession2'>Go to Homepage</a>");
        } else {
            out.println("<h1>Incorrect Login ID/Password</h1>");
            RequestDispatcher rd = request.getRequestDispatcher("/httpsession.html");
            rd.include(request, response);
        }
    }
}
