package com.example.test;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingSystem {

    private Flights flights;
    private ArrayList<Customer> customers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public BookingSystem() {
        this.flights = new Flights("Emirates","EK007",350,"Airbus A-380");
    }

    public boolean bookFlight(String fName,String flightNumber){

        int customer = findCustomer(fName);
        Flights flight = flights.flightObject(flightNumber);
        if(flight != null){
            customers.get(customer).addFlight(flight);
            return true;
            //Flight has been added
        }else{
            return false;
            //Flight not added
        }

        //Lookthrough flights and check that the flight exists then adds the flight and decreases the avaibable seats by 1

    }

    public boolean addFlight(String airline, String flightNumber, int seatsAvailable, String aircraftType){
        //Allows for admins to create a new flight
        if(flights.findFlight(flightNumber) <0){
            flights.addFlight(airline, flightNumber, seatsAvailable, aircraftType);
                    return true;
        }
        return false;

    }

    public void listAvailableFlights(){
        //List all of the avaibleFlights as well as the amount of seats which are left
        flights.getAllFlights();

    }

    public void createCustomer(String fName,String lName){
        //Creates a customer
        customers.add(new Customer(fName,lName));

    }

    public int findCustomer(String fName){
        ArrayList<Customer> customers= getCustomers();
        int index = -1;
        for (int i = 0; i <customers.size() ; i++) {
            if(customers.get(i).getFirstName().equals(fName)){
                index = i;
                return index;
            }
        }
        return index;
    }

    public ArrayList<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    public void bookedCustomerFlights(String fName){
        int index = findCustomer(fName);


        ArrayList<Flights> flights = customers.get(index).flightsBooked;

        for (int i = 0; i <flights.size() ; i++) {
            System.out.println(i+1 + ". "+
                    "airline='" + flights.get(i).getAirline() + '\'' +
                    ", flightNumber='" + flights.get(i).getFlightNumber() + '\'' +
                    ", seatsAvailable=" + flights.get(i).getSeatsAvailable() +
                    ", aircraftType='" + flights.get(i).getSeatsAvailable() + '\'' +
                    ", availableFlights=" + flights.get(i).getSeatsAvailable());
        }

    }

    public void printCustomers(){
        System.out.println(customers.size());
        for (int i = 0; i <customers.size() ; i++) {
            System.out.println(customers.get(i).getFirstName());
        }
    }

    //Test Logout in main
    public void logIn(){
        //Allows for a customer to log in

    }
    public void logOut(){
        //Allows for a customer to log out of their account

    }

}
