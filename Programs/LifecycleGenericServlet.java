import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifecycleGenericServlet extends GenericServlet {

    // Called once when the servlet is initialized
    @Override
    public void init() throws ServletException {
        System.out.println("GenericServlet is being initialized...");
    }

    // Called for each request
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Processing request...");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Welcome to the GenericServlet Lifecycle Example</h2>");
    }

    // Called once when the servlet is being destroyed
    @Override
    public void destroy() {
        System.out.println("GenericServlet is being destroyed...");
    }
}
