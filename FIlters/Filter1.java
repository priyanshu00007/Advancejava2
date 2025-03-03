import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class Filter1 implements Filter {
    public void init(FilterConfig config) {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) 
            throws IOException, ServletException {
        PrintWriter out = resp.getWriter();
        out.print("<p>Filter1: Authentication check before servlet execution</p>");

        HttpServletRequest request = (HttpServletRequest) req;
        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");

        if ("java".equals(login) && "servlet".equals(pwd)) {
            chain.doFilter(req, resp);  // Forward request to the next filter or servlet
        } else {
            out.print("<p>Invalid Login/Password</p>");
        }

        out.print("<p>Filter1: After servlet execution</p>");
    }

    public void destroy() {}
}
