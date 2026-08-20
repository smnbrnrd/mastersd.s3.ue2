package fr.urn.sime.coffeeapp.model;

public class Coffee {
    
    private String type = "Espresso"; // Default type
    private int strength = 5; // Default strength
    private int sugar = 0; // Default sugar

    public Coffee(String type, int strength) {
        this.type = type;
        this.strength = strength;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getSugar() {
        return sugar;
    }
    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "Coffee [type=" + type + ", strength=" + strength + ", sugar=" + sugar + "]";
    }
}
