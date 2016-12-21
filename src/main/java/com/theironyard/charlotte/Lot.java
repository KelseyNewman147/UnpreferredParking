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
    public static ArrayList<Car> parkedCars = new ArrayList<>();

    public Lot(int id, int capacity, int rate) {

        this.id = id;
        this.capacity = capacity;
        this.rate = rate;
    }

    public static ArrayList<Car> getParkedCars() {
        return parkedCars;
    }

    public static void setParkedCars(ArrayList<Car> parkedCars) {
        Lot.parkedCars = parkedCars;
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
                '}';
    }
}
