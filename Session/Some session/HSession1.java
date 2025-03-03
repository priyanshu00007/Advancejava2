import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HSession1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve login parameter
        String login = request.getParameter("login");

        if (login.equals("java")) {
            // Create a session and store login in session attribute
            HttpSession hs = request.getSession();
            hs.setAttribute("s_id", login);

            out.println("<h3>Session Created Successfully</h3>");
            out.println("<a href='HSession2'>Go to Homepage</a>");
        } else {
            // Redirect to login page if credentials are incorrect
            out.println("<h1>Incorrect Login Id/Password</h1>");
            RequestDispatcher rd = request.getRequestDispatcher("/httpsession.html");
            rd.include(request, response);
        }
    }
}
