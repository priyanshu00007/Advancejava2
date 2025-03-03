import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Welcome extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String session = request.getParameter("session_id");
        String username = request.getParameter("login");

        out.println("<h1>Session ID: " + session + "</h1>");
        out.println("<h3>Welcome, " + username + "!</h3>");
    }
}

/*
 * web .xml
 * <web-app>
    <servlet>
        <servlet-name>Valid</servlet-name>
        <servlet-class>Valid</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>Valid</servlet-name>
        <url-pattern>/Valid</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>Welcome</servlet-name>
        <servlet-class>Welcome</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>Welcome</servlet-name>
        <url-pattern>/Welcome</url-pattern>
    </servlet-mapping>
</web-app>

 */