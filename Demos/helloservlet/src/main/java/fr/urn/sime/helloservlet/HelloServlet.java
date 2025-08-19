package fr.urn.sime.helloservlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
    name = "HelloServlet",
    description = "A simple servlet that says hello",
    urlPatterns = {"/hello", "/hello*"},
    initParams = {
        @WebInitParam(name = "defaultName", value = "World")
    }
)
public class HelloServlet extends HttpServlet {

    private String defaultName;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        defaultName = config.getInitParameter("defaultName");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name == null || name.isEmpty()) {
            name = defaultName;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title> Titre </title></head>");
        out.println("<body>");
        out.println("Hello " + name + "!");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}