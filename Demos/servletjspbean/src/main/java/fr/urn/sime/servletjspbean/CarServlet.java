package fr.urn.sime.servletjspbean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
    name = "CarServlet",
    description = "A simple servlet that displays car information",
    urlPatterns = {"/car"}
)
public class CarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mo = request.getParameter("model");
        String sp = request.getParameter("speed");

        if (mo != null && !mo.isEmpty() && sp != null && !sp.isEmpty()) {
            Car car = new Car();
            car.setModel(mo);
            car.setSpeed(Double.parseDouble(sp));
            request.setAttribute("car",car);
        }

        RequestDispatcher dis = request.getRequestDispatcher("car.jsp");
        dis.forward(request,response);
    }
}