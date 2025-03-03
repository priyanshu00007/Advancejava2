//servlet config
/*
// xml file 
<web-app>
    <servlet>
        <servlet-name>MyServlet</servlet-name>
        <servlet-class>MyServlet</servlet-class>
        <init-param>
            <param-name>name</param-name>
            <param-value>cxcy</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>MyServlet</servlet-name>
        <url-pattern>/MyServlet</url-pattern>
    </servlet-mapping>
</web-app>
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class MyServlet extends HttpServlet
{   String msg;
    PrintWriter out;
    public void init(ServletConfig config)throws ServletException
    {        msg = config.getInitParameter("name"); }
    public void doGet(HttpServletRequest request ,HttpServletResponse response) throws 
					ServletException,IOException
    {   response.setContentType("text/html");
        out = response.getWriter();
        out.println("<h1>"+ msg +"</h1>");
    }
    public void destroy()
    {        out.close();    }}
