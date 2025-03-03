import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;

public class Filter2 implements Filter {
    private String permission;

    public void init(FilterConfig config) throws ServletException {
        permission = config.getInitParameter("permit");  // Read init parameter from web.xml
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) 
            throws IOException, ServletException {
        PrintWriter out = resp.getWriter();
        out.print("<p>Filter2: Checking permission before servlet execution</p>");

        if ("yes".equals(permission)) {
            chain.doFilter(req, resp);  // Forward request
        } else {
            out.print("<p>Permission Denied</p>");
        }

        out.print("<p>Filter2: After servlet execution</p>");
    }

    public void destroy() {}
}
