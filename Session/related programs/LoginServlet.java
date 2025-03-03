import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve login credentials from request
        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");

        // Simple validation (Hardcoded for demo)
        if (login.equals("java") && pwd.equals("servlet")) {
            // Creating a session
            HttpSession session = request.getSession();
            session.setAttribute("user", login); // Store user in session

            // Creating a cookie
            Cookie cookie = new Cookie("username", login);
            response.addCookie(cookie); // Add cookie to response

            out.println("<h3>Login Successful! Session and Cookie Created.</h3>");
            out.println("<a href='SessionInfoServlet'>View Session</a>");
        } else {
            out.println("<h3>Incorrect Login ID/Password!</h3>");
        }
    }
}
