import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifecycleServlet extends HttpServlet {

    // Called once when the servlet is initialized
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet is being initialized...");
    }

    // Called for each request
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Processing request...");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2>Welcome to the Servlet Lifecycle Example</h2>");
    }

    // Called once when the servlet is being destroyed
    @Override
    public void destroy() {
        System.out.println("Servlet is being destroyed...");
    }
}
