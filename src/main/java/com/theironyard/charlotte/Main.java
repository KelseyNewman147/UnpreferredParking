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
        ArrayList<Car> parkedCarsLot0 = new ArrayList<>();
        ArrayList<Car> parkedCarsLot1 = new ArrayList<>();
        ArrayList<Car> parkedCarsLot2 = new ArrayList<>();
        ArrayList<Car> parkedCarsLot3 = new ArrayList<>();

        listOfLots.add(new Lot(0, 20, 6, parkedCarsLot0));
        listOfLots.add(new Lot(1, 15, 5, parkedCarsLot1));
        listOfLots.add(new Lot(2, 25, 4, parkedCarsLot2));
        listOfLots.add(new Lot(3, 18, 7, parkedCarsLot3));

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
                        lot.parkedCars.add(newCar);
                 //       lot.setCapacity(lot.getCapacity() - newCar.getSpaces());
                        return serializer.deep(true).serialize(lot.parkedCars);
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
