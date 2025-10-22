package fr.urn.sime.coffeeapp.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.interceptor.Interceptors;

@Named
@RequestScoped
public class CoffeeService {
    
    @Inject 
    @Selected
    private CoffeeMachine coffeeMachine;

    public CoffeeService() {
        System.out.println("CoffeeService:: created");
    }

    @Interceptors(AuthentificationInterceptor.class)
    public Coffee makeCoffee(int strength, int sugar) {
        Coffee coffee = coffeeMachine.brewCoffee(strength);
        coffee.setSugar(sugar);
        return coffee;
    }

    public String getName() {
        return "The M2 SIME Coffee Service";
    }

    @Override
    public String toString() {
        return "CoffeeService{" +
                "coffeeMachine=" + coffeeMachine +
                '}';
    }
}
