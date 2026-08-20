package fr.urn.sime.servletjspbean;

import java.io.Serializable;

public class Car implements Serializable {

    static final long serialVersionUID = 42L;
    private String model;
    private double speed;

    // constructeur par defaut obligatoire (peut être implicite)
    public Car() {
        model = "Bugatti Veyron";
        speed = 407;
    }

    // getters et setters publics
    public double getSpeed() {
        return this.speed;
    }	

    public void setSpeed(double newSpeed) {
        if(newSpeed < 0) {
            newSpeed = Math.abs(newSpeed);
        }
        this.speed = newSpeed;
    }
    
    public String getModel() {
        return this.model;
    }

    public void setModel(String newModel) {
        this.model = newModel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                '}';
    }
}
