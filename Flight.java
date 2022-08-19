package com.example.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Flight {


    //Class which allows for an admin to schedule a flight

    private Airline airline;
    private String duration;
    private String flightNumber;
    private int seatsAvailable;
    private String aircraftType;
    private int totalPassangers;
    private String getAirlineName;
    private String destinationAirport;
    private String departureAirport;

    HashMap<String, Boolean> seats= new HashMap<String, Boolean>();

    public Flight(String duration, int seatsAvailable, String aircraftType,String destinationAirport,String departureAirport,Airline airline) {
        this.airline = airline;
        this.duration = duration;
        this.seatsAvailable = seatsAvailable;
        this.aircraftType = aircraftType;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.flightNumber = genFlightNumber();
        this.getAirlineName = airline.getAirlineName();
        seatGen();

    }

    //Method to autoGenSeats within the plane 20 rows and each row has seats a - i
    private void seatGen(){

        int rows = 20;
        int seatsPerRow = 9;

        for (int i = 1; i <=rows  ; i++) {
            for (int j = 'A'; j <='I' ; j++) {
                char h = (char) j;
                seats.put(String.valueOf(i)+h,false);
            }
        }
    }

    //Method that finds and checks if a seat is free. If continually searches to find a seat that is free
    private int isSeatFree(String seat){
        
        if(seats.get(seat).booleanValue() == true){
            return -1;
        }else{
            return 1;
        }
    }

    private int bookSeat(String seat){
        
        //if -1 = seat booked
        //if 1 = seat is free
        int seatAvailabiility = isSeatFree(seat);
        
        if(seatAvailabiility == -1){
            return -1;
        }else{
            seats.replace(seat,true);
            return 1;
        }
    }

    public void printAllSeats(){

        HashMap<String,Boolean> seatsClone = new HashMap<>(seats);
        for (int i = 0; i <seatsClone.size() ; i++) {
            System.out.println(seatsClone.get(i));
        }
    }

    //Method generates a flightNumber and adds the airline acronym first
    public String genFlightNumber(){
        String acronym = airline.getAirlineAcronym();
        Random rand = new Random();
        return acronym + String.valueOf(rand.nextInt(9999 - 1000) + 1000) ;
    }

    public Ticket generateTicket(String fName, String lName, Flight flight){

        boolean booked = false;
        String seat = randomSeatKeyGen(seats);
        int seatIndex = isSeatFree(seat);

        if(seatIndex == 1){
            bookSeat(seat);
            return new Ticket(fName,lName,seat,flight);
        }else{
            return null;
        }
    }

    //Generates a random seat from the seats available
    public  <K, V> K randomSeatKeyGen(Map<K, V> map) {

        Random rand = new Random();
        int seatIndex = rand.nextInt(seats.size());
        int index =0;

        for (K key: map.keySet()) {
            index ++;
            if (index == seatIndex) {
                return key;
            }
        }
        return null;
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

    public String getDuration() {
        return duration;
    }

    public String getAirlineName(){
        return airline.getAirlineName();
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
}
