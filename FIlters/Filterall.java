import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Filter1 Implementation
@WebFilter("/FilteredServlet")
public class Filterall implements Filter {
    public void init(FilterConfig config) {}
    
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) 
            throws IOException, ServletException {
        PrintWriter out = resp.getWriter();
        out.print("<p>Filter1 is invoked before</p>");
        
        String login = req.getParameter("login");
        String pwd = req.getParameter("pwd");
        
        if ("java".equals(login) && "servlet".equals(pwd)) {
            chain.doFilter(req, resp); // send request to next resource
        } else {
            out.print("<p>Invalid login/password</p>");
        }
        
        out.print("<p>Filter1 is invoked after</p>");
    }
    
    public void destroy() {}
}

// Filter2 Implementation
@WebFilter("/FilteredServlet")
public class Filter2 implements Filter {
    private String permission;
    
    public void init(FilterConfig config) throws ServletException {
        permission = config.getInitParameter("permit");
    }
    
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) 
            throws IOException, ServletException {
        PrintWriter out = resp.getWriter();
        out.print("<p>Filter2 is invoked before</p>");
        
        if ("yes".equals(permission)) {
            chain.doFilter(req, resp);
        } else {
            out.println("Permission Denied");
        }
        
        out.print("<p>Filter2 is invoked after</p>");
    }
    
    public void destroy() {}
}

// FilteredServlet Implementation
@WebServlet("/FilteredServlet")
public class FilteredServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p><h3>Welcome to Servlet</h3></p>");
    }
}
