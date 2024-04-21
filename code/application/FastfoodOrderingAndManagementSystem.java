package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import application.customerui.CustomerInterface;
import application.staffui.StaffInterface;
import exception.InputOutOfRangeException;
import system.Database;

public class FastfoodOrderingAndManagementSystem {
    public static void main(String[] args) {
        Database database = new Database();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------------------------");
            System.out.println("FASTFOOD ORDERING AND MANAGEMENT SYSTEM");
            System.out.println("---------------------------------------");
            System.out.println("Please choose your login option:");
            System.out.println("1. Customer");
            System.out.println("2. Staff");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");

            try {
                int loginChoice = sc.nextInt();
                System.out.println();
                switch (loginChoice) {
                    case 1:
                        new CustomerInterface(sc, database.getBranchList());
                        break;
                    case 2:
                        new StaffInterface(sc, database);
                        break;
                    case 3:
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        throw new InputOutOfRangeException();
                }
            } 
            catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                sc.next();
            }
            catch (InputOutOfRangeException e) {
                System.out.println("Invalid input.");
            }
            finally {
                System.out.println();
            }
        }
    }
}
