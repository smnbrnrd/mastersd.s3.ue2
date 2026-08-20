package fr.urn.mastersime.studentmarks.domain;

import java.time.LocalDate;

public class EvaluationRecord implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    public static enum Type {
        EXAM, PROJECT, PRACTICAL, DEFENSE, REPORT, OTHER
    }

    private String subject;
    private Type type = Type.EXAM;
    private double value;
    private double maxValue;
    private LocalDate date;

    public String getSubject() {
        return subject;
    }
    public Type getType() {
        return type;
    }
    public double getValue() {
        return value;
    }
    public double getMaxValue() {
        return maxValue;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

}