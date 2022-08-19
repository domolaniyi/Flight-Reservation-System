package com.example.test;

import java.util.Random;

public class Ticket {

    private Flight flightInfo;
    private String fName;
    private String lName;
    private String seat;
    private int ticketID;


    public Ticket(String fName, String lName,String seat,Flight flightInfo) {
        this.flightInfo = flightInfo;
        this.fName = fName;
        this.lName = lName;
        this.seat = seat;
        this.ticketID = ticketIDGen();
    }

    //Generates a unique ID for the ticket. Every ticket number must be different
    public int ticketIDGen(){
        Random rand = new Random();
        return rand.nextInt(9999 - 1000) + 1000;
    }

    public Flight getFlightInfo() {
        return flightInfo;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }


    public String getSeat() {
        return seat;
    }

    public int getTicketID() {
        return ticketID;
    }


}
