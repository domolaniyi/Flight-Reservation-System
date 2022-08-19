package com.example.test;

import java.util.ArrayList;

public class NewBookingSystem {

    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();
    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<Airline> airlines = new ArrayList<>();


    public void addAdmins(){
        admins.add(new Admin("test","test","Admin","123"));
    }

    public void TESTaddFlightsandAirlines(){
        airlines.add(new Airline("Emirates","EK"));
        airlines.add(new Airline("BritishAirways","BA"));

        Airline emirates = airlines.get(0);
        Airline BritishAirways = airlines.get(1);
        flights.add(new Flight("7:20",310,"A380","DXB","LHR",emirates));
        flights.add(new Flight("9",280,"Boeing 777","JFK","LHR",BritishAirways));
    }


    //Admin priveledge
    public void addNewAirline(String airlineName, String airlineAcronym){
        airlines.add(new Airline(airlineName,airlineAcronym));
    }

    public Airline returnAirlineObject(String name){

        for (Airline airline : airlines) {
            if (airline.getAirlineName().equals(name)) {
                return airline;
            }
        }
        return null;
    }

    public void adminAddSomeFlights(String findAirlineByName,String duration, int seatsAvailable, String aircraftType, String destinationAirport, String departureAirport){

        Airline airline = returnAirlineObject(findAirlineByName);
        flights.add(new Flight(duration,seatsAvailable,aircraftType,destinationAirport,departureAirport,airline));

    }
    public int verifyLoginCustomer(String userName, String password){

        int customerIndex = findCustomer(userName);
        if(customerIndex >=0){
            if(customers.get(customerIndex).getPassword().equals(password)){
                return customerIndex;
            }else{
                return -1;
            }
        }else{
            return -1;
        }
        //returns -1 if can't find username or password is wrong
    }

    public int verifyLoginAdmin(String userName,String password){
        int adminIndex = findCustomer(userName);
        if(adminIndex >=0){
            if(admins.get(adminIndex).getPassword().equals(password)){
                return adminIndex;
            }else{
                return -1;
            }
        }else{
            return -1;
        }

        //returns -1 if can't find username or password is wrong
    }

    private int findCustomer(String userName){

        int index = -1;
        for (int i = 0; i <customers.size() ; i++) {
            if(customers.get(i).getUserName().equals(userName)){
                index = i;
                return index;
            }
        }
        return index;
    }

    public int findFlight(String flightNumber){

        int index = -1;
        for (int i = 0; i <flights.size() ; i++) {
            if(flights.get(i).getFlightNumber().equals(flightNumber)){
                index = i;
                return index;
            }
        }
        return index;

    }

    public boolean customerBookFlight(int customerIndex, String flightNumber){
        //Creates ticket object and adds it to ticket arraylist within customer class
        int flightIndex = findFlight(flightNumber);

        if(flightIndex >= 0){

            Flight flight = returnFlightObject(flightNumber);
            String fName = customers.get(customerIndex).getFirstName();
            String lName = customers.get(customerIndex).getLastName();

            if(flights.get(flightIndex).generateTicket(fName,lName,flight)!=null){

                Ticket ticket = flights.get(flightIndex).generateTicket(fName,lName,flight);
                customers.get(customerIndex).addAdditionalTicket(ticket);
                int totalSeats = flights.get(flightIndex).getSeatsAvailable();
                flights.get(flightIndex).setSeatsAvailable(totalSeats - 1);
                return true;
            }else{
                return false;
            }
        }
        return false;

    }

    public void listAllAvailableFlights(){

        for (Flight flight : flights) {
            System.out.println("Airline Name: " + flight.getAirlineName() + "\n" + "Flight Number: " + flight.getFlightNumber() + "\n" + "Flight Duration:" +
                    flight.getDuration() + "\n" + "Aircraft Type: " + flight.getAircraftType());
            System.out.println();
        }
    }

    public void createCustomer(String fName,String lName,String userName, String password){
        //Creates a customer
        customers.add(new Customer(fName,lName,userName,password));

    }

    public String returnCustomerName(int index){
        return customers.get(index).getFirstName() + " " +  customers.get(index).getLastName();
    }

    public void printCustomerTickets(int index){
        customers.get(index).printTickets();
    }

    public int customerCancelTicket(int index,String flightNumber){

        // 1 = ticketCanclled
        // -1 = ticket failed to be cancelled


        int flightIndex = findFlight(flightNumber);

        if(flightIndex == -1){
            return -1;
        }else{
            int check = customers.get(index).removeTicket(flightNumber);
            if(check == -1){
                return -1;
            }else{
                return 1;
            }

        }
    }

    public int adminRemoveFlight(String flightNumber){

        // 1 = flight successfully removed
        // -1 = Flight doesn't exist
        int flightIndex = findFlight(flightNumber);

        if(flightIndex ==-1){
            return -1;
        }else{
            flights.remove(flightIndex);
            return 1;
        }
    }

    public int checkUserNameIsUnique(String userName){

        // 1 = userName is unique
        // -1 = userNAME is not unique
        for (Customer customer : customers) {
            if (customer.getUserName().equals(userName)) {
                return -1;
            }
        }
        return 1;
    }


    public Flight returnFlightObject(String flightNumber){

         int index = findFlight(flightNumber);

         if(index >=0){
             return flights.get(index);
         }else{
             return null;
         }
    }

    public void adminPrintAllFlights(){
        for (Flight flight : flights) {
            System.out.println("Airline Name: " + flight.getAirlineName() + "\n" +
                    "Flight Number : " + flight.getFlightNumber() + "\n" +
                    "SeatsAvailable: " + flight.getSeatsAvailable() + " \n" +
                    "Aircraft Type: " + flight.getAircraftType());
        }
    }

    public void adminPrintAllAirlines(){

        for (Airline airline : airlines) {
            System.out.println("Airline Name: " + airline.getAirlineName() + "\n" +
                    "AirlineID:" + airline.getAirlineID() + "\n" +
                    "Airline Acronym" + airline.getAirlineAcronym());
        }
    }

}
