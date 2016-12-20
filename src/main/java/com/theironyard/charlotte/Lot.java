package com.theironyard.charlotte;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.description;

/**
 * Created by kelseynewman on 12/19/16.
 */
public class Lot {
    public int id;
    private int capacity;
    private double rate;

    public Lot(int id, int capacity, int rate) {

        this.id = id;
        this.capacity = capacity;
        this.rate = rate;
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
