package com.theironyard.charlotte;

//import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.description;

import java.util.ArrayList;

/**
 * Created by kelseynewman on 12/19/16.
 */
public class Lot {
    public int id;
    private int capacity;
    private double rate;
    private ArrayList<Car> parkedCars;

    public Lot(){

    }

    public Lot(int id, int capacity, int rate, ArrayList<Car> parkedCars) {

        this.id = id;
        this.capacity = capacity;
        this.rate = rate;
        this.parkedCars = parkedCars;
    }

    public ArrayList<Car> getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(ArrayList<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Lots available {" +
                "ID=" + id +
                ", capacity='" + capacity + '\'' +
                ", rate='" + rate + '\'' +
                ", parked cars" + parkedCars + '\'' +
                '}';
    }
}
