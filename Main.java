package com.example.test;

import java.awt.print.Book;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        Boolean flag = true;
        BookingSystem booking = new BookingSystem();

        while(flag){

            String lastName, firstName,flightNumber;



            System.out.println("1. Create Account" + "\n" +
                    "2. Available flights " + "\n" +
                    "3. Book flights" + "\n" +
                    "4. Add flight " + "\n" +
                    "5. Cancel flight"  + "\n" +
                    "6. Your booked flights" + "\n" +
                    "0. Turn off");

            int num = scanner.nextInt();

            switch (num){
                case 0:
                    System.out.println("Application turning off");
                    flag = false;
                    break;
                case 1:
                    System.out.println("***Create Account***");
                    System.out.println("Enter First Name: ");
                     firstName = scanner.next();
                    System.out.println("Enter Last Name: ");
                     lastName = scanner.next();
                    booking.createCustomer(firstName,lastName);
                    System.out.println("Account created!");
                    break;
                case 2:
                    booking.listAvailableFlights();
                    break;
                case 3:
                    System.out.println("***Book Flight***");
                    System.out.println("Enter First Name: ");
                    firstName = scanner.next();
                    System.out.println("Enter Flight Number: ");
                    flightNumber = scanner.next();
                    if(booking.bookFlight(firstName,flightNumber)){
                        System.out.println("Flight has been successfully booked");
                    }else{
                        System.out.println("Flight has not been booked");
                    }
                    break;
                case 4:
                    System.out.println("Only for admins");
                    break;
                case 5:
                    System.out.println("Cancel flight");
                    break;
                case 6:
                    System.out.println("***Your booked flights***");
                    System.out.println("Enter your name: ");
                    firstName = scanner.next();
                    booking.bookedCustomerFlights(firstName);
                    break;
                case 7:
                    booking.printCustomers();
                    break;
            }


        }


    }
}
