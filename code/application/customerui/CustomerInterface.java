package application.customerui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import branch.Branch;
import item.Item;

public class CustomerInterface {
    public CustomerInterface(ArrayList<Branch> branchList) {
        WelcomePage welcomePage = new WelcomePage(branchList);

        ArrayList<Item> menu = welcomePage.getChosenBranch().getItemList();
        ArrayList<Item> cart = new ArrayList<Item>();
        MenuPage menuPage = new MenuPage(menu);
        CartPage cartPage = new CartPage(cart);
        
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Choose your option:");
            System.out.println("1. Go to Menu");
            System.out.println("2. Go to Cart");
            System.out.println("3. Checkout");
            System.out.print("Enter option: ");
            try {
                int choice = sc.nextInt();
                sc.next();
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
