package com.example.test;

import java.util.ArrayList;

public class Flights {

    //This method allows to create one instance called e.g. "flights" and you can make as many flights with it as you want

    private String airline;
    private String flightNumber;
    //Might need to expose this variable to change it
    //Make a setter
    private int seatsAvailable;
    private String aircraftType;
    private ArrayList<Flights> availableFlights;


    public Flights(String airline, String flightNumber, int seatsAvailable,String aircraftType) {
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.seatsAvailable = seatsAvailable;
        this.aircraftType = aircraftType;
        this.availableFlights = new ArrayList<>();
        availableFlights.add(this);

    }

    public ArrayList<Flights> getAvailableFlights() {
        return new ArrayList<>(availableFlights);
    }


    public String getAirline() {
        return airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    //void for now for testing
    public void getAllFlights(){
        ArrayList<Flights> flights = getAvailableFlights();


        for (int i = 0; i <flights.size() ; i++) {
            System.out.println(i+1 + ". "+
                    "airline='" + flights.get(i).getAirline() + '\'' +
                    ", flightNumber='" + flights.get(i).getFlightNumber() + '\'' +
                    ", seatsAvailable=" + flights.get(i).getSeatsAvailable() +
                    ", aircraftType='" + flights.get(i).getSeatsAvailable() + '\'' +
                    ", availableFlights=" + flights.get(i).getSeatsAvailable());
        }
    }

    public int findFlight(String flightNumber){

        //Finds flight based on "Flight Number"
        //Improve Method to make it Faster!!! e.g.(Binary Search)

        ArrayList<Flights> flights = getAvailableFlights();
        int index = -1;
        for (int i = 0; i <flights.size() ; i++) {
            if(flights.get(i).getFlightNumber().equals(flightNumber)){
                index = i;
                return index;
            }
        }
        return index;
    }

    public boolean addFlight(String airline, String flightNumber, int seatsAvailable,String aircraftType){

        if (findFlight(flightNumber)<0){
            Flights newFlight = new Flights(airline,flightNumber,seatsAvailable,aircraftType);
            availableFlights.add(newFlight);
            return true;
        }
        return false;
        //False meaning hasn't been added
    }

    public boolean removeFlight(String flightNumber){

       int index = findFlight(flightNumber);

        if(index >=0){
            availableFlights.remove(index);
        }
        return false;
    }

    public Flights flightObject(String flightNumber){
        int index = findFlight(flightNumber);
        if(index >= 0 ){
            return availableFlights.get(index);
        }
        return null;
    }


}
