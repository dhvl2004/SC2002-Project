package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import application.customerui.CustomerInterface;
import application.staffui.StaffInterface;
import exception.InputOutOfRangeException;
import system.Database;


/**
 * <li>Class is the entry point for running the whole Fast-Food Management system
 * <li>Serves as the starting UI for staff/manager or customer to interact with, and will direct respective parties to their UI Pages 
 * @author FDAB 2
 * @version 1.0 
 * 
 */
public class FastfoodOrderingAndManagementSystem {
    public static void main(String[] args) {
        Database database = new Database();
        database.loadFiles();
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
                        database.saveFiles();
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
            catch (Exception e) {
            	System.out.println(e.getMessage());
            	database.saveFiles();
            }
            finally {
                System.out.println();
            }
        }
    }
}
