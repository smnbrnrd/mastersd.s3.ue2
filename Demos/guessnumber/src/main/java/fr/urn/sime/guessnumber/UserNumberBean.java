package fr.urn.sime.guessnumber;

import java.io.Serializable;
import java.util.Random;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class UserNumberBean implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    private Integer randomInt = null;
    private Integer userNumber = null;
    private int maximum = 10;
    private int minimum = 0;

    public UserNumberBean() {
        Random randomGR = new Random();
        randomInt = Integer.valueOf(randomGR.nextInt(maximum + 1));
        System.out.println("Sime's number: " + randomInt);
    }

    public void setUserNumber(Integer user_number) {
        userNumber = user_number;
    }
    public Integer getUserNumber() {
        return userNumber;
    }
    public String getResponse() {
        if ((userNumber == null) || (userNumber.compareTo(randomInt) != 0)) {
            return "Sorry, " + userNumber + " is incorrect.";
        } else {
            return "Yay! You got it!";
        }
    }
    public int getMaximum() {
        return (this.maximum);
    }
    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
    public int getMinimum() {
        return (this.minimum);
    }
    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }
}