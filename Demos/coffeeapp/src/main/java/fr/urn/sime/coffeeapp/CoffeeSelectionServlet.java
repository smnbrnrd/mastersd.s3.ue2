package fr.urn.sime.coffeeapp;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
    name = "CoffeeSelectionServlet",
    urlPatterns = {"/selection"}
)
public class CoffeeSelectionServlet extends HttpServlet {
    
    @Inject
    private CoffeeSelector coffeeSelector;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        String coffeeType = request.getParameter("coffeeType");
        if (coffeeType != null) {
            if (coffeeType.equals("espresso")) {
                coffeeSelector.setType(CoffeeSelector.EXPRESSO);
            } else if (coffeeType.equals("filter")) {
                coffeeSelector.setType(CoffeeSelector.FILTER);
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid coffee type");
                return;
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/selection.jsp");
        dispatcher.forward(request, response);
    }
}
