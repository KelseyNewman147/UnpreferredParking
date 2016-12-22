package com.theironyard.charlotte;

/**
 * Created by kelseynewman on 12/19/16.
 */
public class Car {
    private String make;
    private String model;
    private int spaces;
    private double money;
    private int id;

    public Car() {

    }

    public Car(String make, String model, int spaces, double money, int id) {
        this.make = make;
        this.model = model;
        this.spaces = spaces;
        this.money = money;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {

        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpaces() {
        return spaces;
    }

    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
