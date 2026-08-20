package fr.urn.sime.coffeeapp.controller;

import java.io.IOException;

import fr.urn.sime.coffeeapp.model.CoffeeSelector;
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
        coffeeSelector.setStrength(Integer.parseInt(request.getParameter("strength")));
        coffeeSelector.setSugar(Integer.parseInt(request.getParameter("sugar")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/coffee");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        doGet(request, response);
    }
}
