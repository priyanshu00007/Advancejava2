import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Allcookies extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get action parameter from request
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                createCookie(response, out);
                break;
            case "read":
                readCookies(request, out);
                break;
            case "update":
                updateCookie(request, response, out);
                break;
            case "delete":
                deleteCookies(request, response, out);
                break;
            default:
                out.println("<h3>Invalid Action! Use ?action=create | read | update | delete</h3>");
        }
    }

    // 1️⃣ Create Cookie
    private void createCookie(HttpServletResponse response, PrintWriter out) {
        Cookie userCookie = new Cookie("username", "Priyanshu");
        userCookie.setMaxAge(60 * 60 * 24); // 1-day expiration
        response.addCookie(userCookie);
        
        out.println("<h3>✅ Cookie Created: username = Priyanshu</h3>");
        out.println("<a href='?action=read'>Read Cookie</a>");
    }

    // 2️⃣ Read Cookies
    private void readCookies(HttpServletRequest request, PrintWriter out) {
        Cookie[] cookies = request.getCookies();
        out.println("<h3>🍪 Stored Cookies:</h3>");
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.println("<p>" + cookie.getName() + " = " + cookie.getValue() + "</p>");
            }
        } else {
            out.println("<p>No cookies found!</p>");
        }
    }

    // 3️⃣ Update Cookie
    private void updateCookie(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        Cookie[] cookies = request.getCookies();
        boolean updated = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    cookie.setValue("UpdatedUser");
                    response.addCookie(cookie);
                    updated = true;
                    break;
                }
            }
        }

        if (updated) {
            out.println("<h3>🔄 Cookie Updated: username = UpdatedUser</h3>");
        } else {
            out.println("<h3>❌ No cookie found to update.</h3>");
        }

        out.println("<a href='?action=read'>Check Updated Cookie</a>");
    }

    // 4️⃣ Delete Cookies
    private void deleteCookies(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        Cookie[] cookies = request.getCookies();
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0); // Deleting the cookie
                response.addCookie(cookie);
            }
            out.println("<h3>🗑️ All Cookies Deleted!</h3>");
        } else {
            out.println("<h3>⚠️ No cookies found to delete.</h3>");
        }
    }
}

/*
 * Web.xml
 *<web-app>
    <servlet>
        <servlet-name>CookieManager</servlet-name>
        <servlet-class>CookieManager</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>CookieManager</servlet-name>
        <url-pattern>/CookieManager</url-pattern>
    </servlet-mapping>
</web-app>

 */