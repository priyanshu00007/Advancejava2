import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class DoGetDemo extends HttpServlet
{    PrintWriter out;
    public void init(ServletConfig config)throws ServletException
    {    }
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException
    {
        String email=request.getParameter("email");
        response.setContentType("text/html"); 
        out =response.getWriter();
        out.println("my email:"+email);
    }
    public void destroy()
    {        out.close();    }
 }
