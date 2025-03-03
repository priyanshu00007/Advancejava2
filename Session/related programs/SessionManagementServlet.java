import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SessionManagementServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();

        switch (action) {
            case "login":
                handleLogin(request, response, session, out);
                break;
            case "readCookie":
                readCookies(cookies, out);
                break;
            case "deleteCookie":
                deleteCookies(response, out);
                break;
            case "sessionInfo":
                displaySessionInfo(session, out);
                break;
            case "invalidateSession":
                invalidateSession(session, out);
                break;
            default:
                out.println("<h3>Invalid Action!</h3>");
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session, PrintWriter out) 
        throws IOException {
        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");

        if (login.equals("java") && pwd.equals("servlet")) {
            session.setAttribute("user", login); // Storing in session
            Cookie cookie = new Cookie("username", login);
            response.addCookie(cookie); // Adding cookie

            out.println("<h3>Login Successful! Cookie and Session Set.</h3>");
            out.println("<a href='?action=sessionInfo'>View Session</a>");
        } else {
            out.println("<h3>Incorrect Login ID/Password</h3>");
        }
    }

    private void readCookies(Cookie[] cookies, PrintWriter out) {
        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<h3>Cookie: " + c.getName() + " = " + c.getValue() + "</h3>");
            }
        } else {
            out.println("<h3>No Cookies Found!</h3>");
        }
    }

    private void deleteCookies(HttpServletResponse response, PrintWriter out) {
        Cookie cookie = new Cookie("username", ""); 
        cookie.setMaxAge(0); // Deletes cookie
        response.addCookie(cookie);

        out.println("<h3>Cookie Deleted Successfully!</h3>");
    }

    private void displaySessionInfo(HttpSession session, PrintWriter out) {
        String user = (String) session.getAttribute("user");

        if (user != null) {
            out.println("<h3>Session Active: Welcome " + user + "</h3>");
            out.println("<a href='?action=invalidateSession'>Logout</a>");
        } else {
            out.println("<h3>No Active Session!</h3>");
        }
    }

    private void invalidateSession(HttpSession session, PrintWriter out) {
        session.invalidate();
        out.println("<h3>Session Invalidated. Logged Out.</h3>");
    }
}
