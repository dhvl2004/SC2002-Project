package application.customerui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import cart.Cart;
import cart.CartItem;
import cart.CartManagement;
import exception.InputOutOfRangeException;
import item.Item;

class MenuPage {
    private Scanner sc;
    private ArrayList<Item> menu;
    private CartManagement cartManagement;

    MenuPage() {
    	
    }
    
    MenuPage(Scanner sc, ArrayList<Item> menu, Cart cart) {
        this.sc = sc;
        this.menu = menu;
        this.cartManagement = new CartManagement(cart);
        this.displayMenu();
        System.out.println("Please choose your action:");
        System.out.println("1. Add item to cart");
        System.out.println("2. Go back");
        System.out.print("Enter your choice: ");
        try {
            int menuActionChoice = sc.nextInt();
            System.out.println();
            switch (menuActionChoice) {
                case 1:
                    this.addItemToCart();
                    break;
                case 2:
                    return;
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

    private void displayMenu() {
        System.out.println("---MENU---");
        System.out.println("ID\t\t\tName\t\t\tPrice\t\t\tCategory\t\t\tDescription");
        for (Item item: this.menu) {
            System.out.println(item.getId() + "\t\t\t" + item.getName() + "\t\t\t" + item.getPrice() + 
            		"\t\t\t" + item.getCategory() + "\t\t\t" + item.getDescription());
        }
        System.out.println();
    }

    private void addItemToCart() {
        System.out.println("---Add item to cart---");
        System.out.print("Enter Item ID: ");
        String itemId = sc.next();
        for (Item item: this.menu) {
            if (itemId.equals(item.getId())) {
                System.out.print("Enter quantity: ");
                int quantity = sc.nextInt();
                try {
                    if (quantity == 0) {
                        throw new InputOutOfRangeException();
                    }
                    this.cartManagement.addCartItem(new CartItem(item, quantity));
                    System.out.println("Item added successfully!");
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
                return;
            }
        }
        System.out.println("Item ID not found!");
    }
}
