package com.example.test;

import java.util.ArrayList;

public class Customer {

    private String firstName;
    private String lastName;
    private String ID;
    private String userName;
    private String password;
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();


    public Customer(String firstName, String lastName,String username,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = username;
        this.password = password;
    }

    public int findTicket(String flightNumber){

        int index = -1;
        for (int i = 0; i <tickets.size() ; i++) {
            if(tickets.get(i).getFlightInfo().getFlightNumber().equals(flightNumber)){
                index = i;
                return index;
            }
        }
        return index;
    }

    public int removeTicket(String flightNumber){
        int ticketIndex = findTicket(flightNumber);
        if(ticketIndex == -1){
            return -1;
        }else{
            tickets.remove(ticketIndex);
            return 1;
        }
    }

    public void printTickets(){
        for (int i = 0; i <tickets.size() ; i++) {
            System.out.println("Airline Name: " + tickets.get(i).getFlightInfo().getAirlineName() + "\n" +
                                "Flight Number:" + tickets.get(i).getFlightInfo().getFlightNumber() + "\n" +
                                    "Seat: " + tickets.get(i).getSeat() + "\n"+
                                        "Duration: " + tickets.get(i).getFlightInfo().getDuration() + "\n" +
                                            "AircraftType: " +  tickets.get(i).getFlightInfo().getAircraftType()+"\n");
        }
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

    public ArrayList<Ticket> getTicketsBooked() {
        return new ArrayList<>(tickets);
    }

    public void addAdditionalTicket(Ticket ticket){
        tickets.add(ticket);
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public String getPassword() {
        return password;
    }

}
