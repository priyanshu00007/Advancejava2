import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HyperLinkDemo extends HttpServlet {
    private String msg;

    // Servlet initialization
    public void init(ServletConfig config) throws ServletException {
        super.init(config);  // Best practice to call super.init()
        msg = "Hello, world! My first Servlet Program...";
    }

    // Handling GET request
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        // Declaring PrintWriter inside the method to prevent global scope issues
        PrintWriter out = response.getWriter();
        out.println("<h1>" + msg + "</h1>");
        out.close(); // Closing the writer after use
    }

    // Servlet destruction
    public void destroy() {
        System.out.println("Servlet is being destroyed...");
    }
}


// .xml
/*
 <servlet>
    <servlet-name>HyperLinkDemo</servlet-name>
    <servlet-class>HyperLinkDemo</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>HyperLinkDemo</servlet-name>
    <url-pattern>/hyperlink</url-pattern>
</servlet-mapping>

 */