package fr.urn.sime.coffeeapp;

import jakarta.enterprise.inject.Typed;

@Filter
@Typed(CoffeeMachine.class)
public class FilterCoffeeMachine implements CoffeeMachine {

    @Override
    public Coffee brewCoffee(int strength) {
        return new Coffee("Filter Coffee", strength);
    }
    public void addWater() {
        System.out.println("Water added");
    }
    public void addCoffee() {
        System.out.println("Coffee added");
    }

    @Override
    public String toString() {
        return "FilterCoffeeMachine{}";
    }
}
