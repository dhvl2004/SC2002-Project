package application.customerui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import branch.Branch;
import item.Item;

public class CustomerInterface {
    private Branch currentBranch;
    public CustomerInterface(ArrayList<Branch> branchList) {

        System.out.println("LOGIN AS CUSTOMER");
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Please choose your current branch:");
            for (int i = 0; i < branchList.size(); i++) {
                System.out.println((i + 1) + ". " + branchList.get(i).getBranchName());
            }
            System.out.println();

            System.out.print("Please enter the branch index: ");
            int choice = sc.nextInt();

            if (choice < 1 || choice > branchList.size()) {
                sc.close();
                throw new InputMismatchException("Invalid branch index.");
            }

            this.currentBranch = branchList.get(choice - 1);
            System.out.println("You are currently in " + this.currentBranch.getBranchName());
        } 
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid branch index.");
        } 

        ArrayList<Item> menu = this.currentBranch.getItemList();
        ArrayList<Item> cart = new ArrayList<Item>();
        MenuPage menuPage = new MenuPage(menu);
        CartPage cartPage = new CartPage(cart);
        
        boolean running = true;
        while (running) {
            System.out.println("Choose your option:");
            System.out.println("1. Go to Menu");
            System.out.println("2. Go to Cart");
            System.out.println("3. Checkout");
            System.out.print("Enter option: ");
            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        menuPage.displayMenu();
                        break;
                    case 2:
                        cartPage.displayCart();
                        break;
                    case 3:
                        // Add checkout logic here
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Consume invalid input
            }
        }
        sc.close();
    }
}
