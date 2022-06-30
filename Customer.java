package com.example.test;

import java.util.ArrayList;

public class Customer {

    private String firstName;
    private String lastName;
    private String ID;
    //TempArray to store flights
    ArrayList<Flights> flightsBooked;


    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightsBooked = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID() {
        return ID;
    }

    public ArrayList<Flights> getFlightsBooked() {
        return new ArrayList<>(flightsBooked);
    }

    public void addFlight(Flights flight){
        flightsBooked.add(flight);
    }

    public void removeFlight(Flights flight){
        if(flightsBooked.contains(flight)){
            flightsBooked.remove(flight);
        }
    }


}
