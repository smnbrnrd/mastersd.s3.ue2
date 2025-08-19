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
    name = "CoffeeServlet",
    urlPatterns = {"/coffee"}
)
public class CoffeeServlet extends HttpServlet {

    @Inject
    private CoffeeService coffeeService;

    @Inject
    private CoffeeSelector coffeeSelector;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        Coffee coffee = coffeeService.makeCoffee(this.coffeeSelector.getStrength(), this.coffeeSelector.getSugar());
        request.setAttribute("coffee", coffee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/coffee.jsp");
        dispatcher.forward(request, response);
    }
}
