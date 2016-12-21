package com.theironyard.charlotte;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import spark.Spark;

import java.util.ArrayList;

import static spark.Spark.before;

public class Main {
    private static ArrayList<Lot> listOfLots = new ArrayList<>();
    private static JsonParser parser = new JsonParser();
    private static JsonSerializer serializer = new JsonSerializer();

    public static void main(String[] args) {
        listOfLots.add(new Lot(0, 20, 6));
        listOfLots.add(new Lot(1, 15, 5));
        listOfLots.add(new Lot(2, 25, 4));
        listOfLots.add(new Lot(3, 18, 7));

        Lot.parkedCars.add(new Car("Toyota", "Matrix", 2, 25, 0));
        Lot.parkedCars.add(new Car("Hyundai", "Elantra", 2, 43, 1));
        Lot.parkedCars.add(new Car("Toyota", "Tacoma", 3, 36, 2));
        Lot.parkedCars.add(new Car("Toyota", "Highlander", 4, 50, 3));

        String port = System.getenv("PORT");

        if (port != null) {
            Spark.port(Integer.valueOf(port));
        }

        //list the lots that are available
        Spark.get("/lot", (request, response) -> {
            System.out.println("Somebody wants to park.");
            return serializer.deep(true).serialize(listOfLots);
        });

        //try to park the car in one of the lots
        Spark.post("/park", (request, response) -> {
            Car newCar = parser.parse(request.body(), Car.class);
            //takes in the information for the newCar that FE puts in and creates a new Car object
            //data sent through request.body
            for (Lot lot : listOfLots) {
                if (lot.id == newCar.getId()) {
                    //make sure newCar fits into lot and has enough money to pay fee
                    if (lot.getCapacity() >= newCar.getSpaces() && newCar.getMoney() >= (newCar.getSpaces() * lot.getRate())) {
                        //park car
                        //reduce lot's capacity by number of spaces car uses
                        System.out.println("Car is now parked.");
   //                     lot.parkedCars.add(newCar);
                        lot.setCapacity(lot.getCapacity() - newCar.getSpaces());
                    }
                }
            }
            System.out.println(listOfLots);
            return "";
        });

        Spark.before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
        });
    }
}
