//dopost method is used to get the values from the form and compare the values and display the maximum number
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Max extends HttpServlet
{   public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
    {   int n1=0,n2=0;
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        n1=Integer.parseInt(request.getParameter("no1"));
        n2=Integer.parseInt(request.getParameter("no2"));
        if(n1>n2)
            out.println("n1="+n1+"is max number");
        else if(n2>n1)
            out.println("n2="+n2+"is max number");
        else if(n1==n2)
            out.println("n1= "+n1+"and n2=  "+n2+"are equal numbers");
    }
}
