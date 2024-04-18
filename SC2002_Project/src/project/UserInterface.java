package project;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("==============================================================");
            System.out.println("Welcome to Fastfood Ordering and Management System (FOMS)!");
            System.out.println("Enter either key... ");
            System.out.println("'C' -> for Customer");
            System.out.println("'S' -> for Staff");
            System.out.println("'Q' -> to Quit");
            System.out.println();

            String userInput = scan.next();

            switch (userInput.toUpperCase()) {
                case "C":
                    System.out.println("You've selected Customer.");
                    CustomerInterface customerInterface = new CustomerInterface();
                    customerInterface.customerInterface();
                    running = false;
                    break;
                    
                case "S":
                    System.out.println("You've selected Staff.");
                    // Call staff related functions or methods here
                    running = false;
                    break;
                    
                case "Q":
                    System.out.println("Quitting...");
                    running = false; // Set running to false to exit the loop
                    break;
                    
                default:
                    System.out.println("Invalid input. Please enter 'C' for Customer, 'S' for Staff, or 'Q' to quit.");
                    break;
            }
        }

        System.out.println("- Program has ended - \n");
        System.out.println("Thank you for patronising.");
        System.out.println("See you again!");
        System.out.println("==============================================================");

        scan.close();

    }
    
}
