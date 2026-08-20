package fr.urn.sime.coffeeapp.model;

import jakarta.enterprise.inject.Typed;

@Typed(CoffeeMachine.class)
public class ExpressoCoffeeMachine implements CoffeeMachine {

    @Override
    public Coffee brewCoffee(int strength) {
        return new Coffee("Espresso", strength);
    }
    public void addWater() {
        System.out.println("Water added");
    }

    @Override
    public String toString() {
        return "ExpressoCoffeeMachine{}";
    }

}
