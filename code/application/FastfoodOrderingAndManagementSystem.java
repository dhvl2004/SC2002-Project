package application;

import java.util.Scanner;

import application.customerui.CustomerInterface;
import application.staffui.StaffInterface;
import system.Database;

public class FastfoodOrderingAndManagementSystem {
    public static void main(String[] args) {
        Database database = new Database();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose your login option:");
            System.out.println("1. Customer");
            System.out.println("2. Staff");
            System.out.println("3. Quit");
            System.out.print("Please enter your option: ");
            int choice = sc.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    CustomerInterface customerInterface = new CustomerInterface(database.getBranchList());
                    break;
                case 2:
                    StaffInterface staffInterface = new StaffInterface(database);
                    break;
                default:
                    sc.close();
                    System.exit(0);
                    break;
            }
        }
    }
}