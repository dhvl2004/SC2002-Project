package application.customerui;

import java.util.ArrayList;
import java.util.Scanner;

import branch.Branch;

public class CustomerInterface {

    public CustomerInterface(ArrayList<Branch> branchList) {
        WelcomePage welcomePage = new WelcomePage(branchList);
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose your option:");
            System.out.println("1. Go to Menu");
            System.out.println("2. Go to Cart");
            System.out.println("3. Checkout");
            System.out.print("Enter option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    
                    break;
                case 2:

                    break;
                default:
                
                    break;
            }
        }
    }
}
