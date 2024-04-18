package application.customerui;

import java.util.ArrayList;
import java.util.Scanner;

import cart.Cart;
import cart.CartItem;
import cart.CartManagement;
import item.Item;

class MenuPage {
    private ArrayList<Item> menu;

    MenuPage(Scanner sc, ArrayList<Item> menu, Cart cart) {
        this.menu = menu;
        CartManagement cartManagement = new CartManagement(cart);
        this.displayMenu();
        while (true) {
            System.out.println("Please enter your action:");
            System.out.println("1. Add item to cart");
            System.out.println("2. Go back");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    boolean itemNotFound = true;
                    System.out.print("Enter Item ID: ");
                    String itemId = sc.next();
                    for (Item item: this.menu) {
                        if (itemId.equals(item.getId())) {
                            System.out.print("Enter quantity: ");
                            int quantity = sc.nextInt();
                            cartManagement.addCartItem(new CartItem(item, quantity));
                            break;
                        }
                    }
                    if (itemNotFound) {
                        System.out.println("Item ID not found!");
                    }
                    break;
                case 2:
                    return;
                default:
                    return;
            }
        }
    }

    public void displayMenu() {
        System.out.println("ID\t\tName\t\tPrice\t\tCategory");
        for (Item item: this.menu) {
            System.out.println(item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getCategory());
        }
    }
}
