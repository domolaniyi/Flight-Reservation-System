package com.example.test;

import java.util.Scanner;


public class TestMain {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        int index = -1;
        boolean adminLog = false;
        int num;
        Boolean flag = true;
        NewBookingSystem booking = new NewBookingSystem();
        booking.addAdmins();
        booking.TESTaddFlightsandAirlines();

        while(flag){

            String lastName, firstName,password,userName;

            if(index ==-1&&adminLog==false){
                //Not logged in
                System.out.println("You are not logged in!");
                System.out.println("1. Create Account" + "\n" +
                    "2. Login " + "\n" +
                                "3. Admin login" + "\n"+
                    "0. Quit" + "\n");
                num= input.nextInt();

                switch (num){
                    case 0:
                        System.out.println("System turning off");
                        flag = false;
                        break;
                    case 1:
                        System.out.println("**Create Account**");
                        System.out.println("Enter your FirstName: ");
                        String fName = input.next();
                        System.out.println("Enter your LastName: ");
                        String lName = input.next();
                        System.out.println("Enter a Username: ");
                        String uName = input.next();
                        int uniqueName = booking.checkUserNameIsUnique(uName);
                        if(uniqueName == 1){
                            System.out.println("Enter a password: ");
                            String pWord = input.next();
                            booking.createCustomer(fName,lName,uName,pWord);
                            System.out.println("New account created");
                            break;
                        }else{
                            boolean flag1 = true;
                            while(flag1){
                                System.out.println("Enter a unique Username: ");
                                String newUserName = input.next();

                                if(booking.checkUserNameIsUnique(newUserName) == 1){
                                    flag1 = false;
                                }
                            }
                            System.out.println("Enter a password: ");
                            String pWord = input.next();
                            booking.createCustomer(fName,lName,uName,pWord);
                            System.out.println("New account created");
                            break;
                        }


                    case 2:
                        System.out.println("**Customer Login**");
                        System.out.println("Enter a Username: ");
                        String uNamee = input.next();
                        System.out.println("Enter a password: ");
                        String pWordd = input.next();

                        boolean flag2 = true;

                        while(flag2){
                            if(booking.verifyLoginCustomer(uNamee,pWordd) >= 0){
                                index = booking.verifyLoginCustomer(uNamee,pWordd);
                                flag2 = false;
                            }else{
                                System.out.println("Re enter password: ");
                                pWordd = input.next();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("**Admin Login**");
                        System.out.println("Enter username: ");
                        String aName = input.next();
                        System.out.println("Enter a password: ");
                        String aPWord = input.next();

                        boolean flag3 = true;

                        while(flag3){
                            if(booking.verifyLoginAdmin(aName,aPWord) == -1){
                                System.out.println("Enter a password: ");
                                pWordd = input.next();
                            }else{
                                index = booking.verifyLoginAdmin(aName,aPWord);
                                adminLog = true;
                                flag3 = false;
                            }
                        }
                        break;
                }
            } if(adminLog == true){

                System.out.println("Welcome Admin");
                System.out.println("**Options**");
                System.out.println("0. Logout" + " \n" +
                        "1. Add new flight" + "\n" +
                        "2. Add new airline" + "\n" +
                        "3. Show all flights" + "\n"+
                        "4. Show all airlines"+ "\n" +
                        "5. Remove a flight");

                num = input.nextInt();

                switch (num){
                    case 0:
                        index = -1;
                        adminLog = false;
                        System.out.println("You have been logged out");
                        break;
                    case 1:
                        System.out.println("**Add a flight**");
                        System.out.println("Enter airline name: ");
                        String airlineName = input.next();
                        System.out.println("Enter duration: ");
                        String duration = input.next();
                        System.out.println("Enter Seats available: ");
                        int seatsAvailable = input.nextInt();
                        System.out.println("Enter destination airport: ");
                        String destinationAirport = input.next();
                        System.out.println("Enter departure airport: ");
                        String departureAirport = input.next();
                        System.out.println("Enter aircraft type: ");
                        String aircraftType = input.next();
                        booking.adminAddSomeFlights(airlineName,duration,seatsAvailable,aircraftType,destinationAirport,departureAirport);
                        break;
                    case 2:
                        System.out.println("**Add airline**");
                        System.out.println("Enter airline name: ");
                        String newAirlineName = input.next();
                        System.out.println("Enter airline acronym: ");
                        String newAirlineAcronym = input.next();
                        booking.addNewAirline(newAirlineName,newAirlineAcronym);
                        break;

                    case 3:
                        System.out.println("Show all flights");
                        booking.adminPrintAllFlights();
                        break;
                    case 4:
                        System.out.println("Show all airlines");
                        booking.adminPrintAllAirlines();
                        break;

                    case 5:
                        System.out.println("**Delete Flight**");
                        System.out.println("Enter Flight Number: ");
                        String deleteFlight = input.next();
                        boolean flag1 = true;
                        while(flag1){
                            if(booking.adminRemoveFlight(deleteFlight)== -1){
                                booking.adminRemoveFlight(deleteFlight);
                                System.out.println("Flight removed");
                                flag1 = false;
                            }else{
                                System.out.println("Enter a valid flight Number: ");
                                deleteFlight = input.next();
                            }
                        }
                        break;
                }
            }

            if(index>=0&&adminLog==false){
                //Logged in
                System.out.println("Welcome " +  booking.returnCustomerName(index));

                System.out.println("**Options**");
                System.out.println("0. Logout" + " \n" +
                            "1. Find Flights" + "\n" +
                                "2. Book Flight" + "\n" +
                                "3. Cancel FLight" + "\n" +
                                "4. Booked Tickets");
                num= input.nextInt();

                switch (num){
                    case 0:
                        index = -1;
                        System.out.println("You have been logged out");
                        break;
                    case 1:
                        booking.listAllAvailableFlights();
                        break;
                    case 2:
                        System.out.println("**Book Flight**");
                        System.out.println("Enter a FlightNumber: ");
                        String flightNumber = input.next();
                        boolean flag1 = true;

                        while(flag1){
                            if(booking.findFlight(flightNumber) >=0){
                                booking.customerBookFlight(index,flightNumber);
                                System.out.println("Flight booked and ticket added to account");
                                flag1 = false;
                            }else{
                                System.out.println("Enter a valid flight number: ");
                                flightNumber = input.next();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("**Cancel Flight**");
                        System.out.println("Enter Flight Number: ");
                        String cancelFlightNumber = input.next();
                        boolean flag2 = true;
                        while(flag2){
                            if(booking.findFlight(cancelFlightNumber) >=0){
                                booking.customerCancelTicket(index,cancelFlightNumber);
                                System.out.println("Flight booked and ticket added to account");
                                flag2 = false;
                            }else{
                                System.out.println("Enter a valid flight number: ");
                                cancelFlightNumber = input.next();
                            }
                        }
                        break;
                    case 4:
                        System.out.println("**Booked Tickets**");
                        booking.printCustomerTickets(index);
                        break;
                }

            }


        }


    }
}
