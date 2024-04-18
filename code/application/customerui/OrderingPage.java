package application.customerui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import cart.Cart;
import item.Item;

class OrderingPage {
    private boolean checkedOut = false;

    OrderingPage(Scanner sc, ArrayList<Item> menu) {
        Cart cart = new Cart();
        while (true) {
            System.out.println("Choose your option:");
            System.out.println("1. Go to Menu");
            System.out.println("2. Go to Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Go Back");
            System.out.println();
            System.out.print("Enter option: ");
            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        new MenuPage(sc, menu, cart);
                        break;
                    case 2:
                        new CartPage(sc, cart);
                        cart.displayCart();
                        System.out.println("");
                        break;
                    case 3:
                        if (cart.isEmpty()) {
                            System.out.println("You have no item in your cart! Please try again.");
                            break;
                        }
                        else {
                            checkedOut = true;
                            return;
                        }
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }
}
