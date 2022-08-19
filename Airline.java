package com.example.test;

import java.util.Random;

public class Airline {

    private String airlineName;
    private int airlineID;
    private String airlineAcronym;


    public Airline(String airlineName,String airlineAcronym) {
        this.airlineName = airlineName;
        this.airlineAcronym = airlineAcronym;
        this.airlineID = idGen();
    }

    public int idGen(){
        Random rand = new Random();
        return rand.nextInt(9999 - 1000) + 1000;
    }


    public String getAirlineName() {
        return airlineName;
    }

    public int getAirlineID() {
        return airlineID;
    }

    public String getAirlineAcronym() {
        return airlineAcronym;
    }


}
