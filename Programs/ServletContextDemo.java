/*
 * <web-app>  
 ...
  <context-param>  
    <param-name>parametername</param-name>  
    <param-value>parametervalue</param-value>  
  </context-param>  
 ...   
 <servlet>
     ...
  </servlet>
</web-app>  
//this
<?xml version="1.0" encoding="UTF-8"?>
<web-app>
    <servlet>
        <servlet-name>ServletContextDemo</servlet-name>
        <servlet-class>ServletContextDemo</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>ServletContextDemo</servlet-name>
        <url-pattern>/ServletContextDemo</url-pattern>
    </servlet-mapping>
    <context-param>  
        <param-name>name</param-name>  
        <param-value>DIET</param-value>  
    </context-param>  
</web-app>


 */

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class ServletContextDemo extends HttpServlet{  
    public void doGet(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException  
{   res.setContentType("text/html");  
    PrintWriter out=res.getWriter();  
    //creating ServletContext object  
    ServletContext context=getServletContext();  
    //Getting the value of the initialization parameter and printing it  
    String college=context.getInitParameter("name");  
    out.println("College name is="+college);  
    out.close();  
 }} 
