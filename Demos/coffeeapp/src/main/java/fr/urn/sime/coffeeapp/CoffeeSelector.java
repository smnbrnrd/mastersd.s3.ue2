package fr.urn.sime.coffeeapp;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class CoffeeSelector {

    public static final int FILTER = 1;
    public static final int EXPRESSO = 2;

    private int type = FILTER;
    private int strength = 1; // Default strength
    private int sugar = 0; // Default sugar

    @Produces
    @Selected
    public CoffeeMachine getCoffeeMachine() {
        System.out.println("CoffeeSelector:: Producing CoffeeMachine of type: " + type);
        if (this.type == EXPRESSO) {
            return new ExpressoCoffeeMachine();
        }
        return new FilterCoffeeMachine();
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        if (type == EXPRESSO || type == FILTER) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid coffee type");
        }
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException("Strength cannot be negative");
        }
        this.strength = strength;
    
    }
    public int getSugar() {
        return sugar;
    }
    public void setSugar(int sugar) {
        if (sugar < 0) {
            throw new IllegalArgumentException("Sugar cannot be negative");
        }
        this.sugar = sugar;
    }
    @Override
    public String toString() {
        return "CoffeeSelector{" +
                "type=" + type +
                ", strength=" + strength +
                ", sugar=" + sugar +
                '}';
    }
}
