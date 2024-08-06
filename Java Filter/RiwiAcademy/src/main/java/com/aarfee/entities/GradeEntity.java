package com.aarfee.entities;

public class GradeEntity {
    private int id;
    private double value;
    private int subscriptionId;

    public GradeEntity() {}

    public GradeEntity(int id, double value, int subscriptionId) {
        this.id = id;
        this.value = value;
        this.subscriptionId = subscriptionId;
    }

    public GradeEntity(double value, int subscriptionId) {
        this.value = value;
        this.subscriptionId = subscriptionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @Override
    public String toString() {
        return "Grade w/ ID: " + this.id +
                ", Value: " + this.value +
                ", Subscription ID: " + this.subscriptionId;
    }
}
