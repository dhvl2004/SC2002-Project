package application.customerui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import cart.Cart;
import cart.CartItem;
import cart.CartManagement;
import exception.InputOutOfRangeException;
import item.Item;


/**
 * <li>class facilitates the menu selection UI for customers
 * <li>It is the page where customers will choose what items from the menu they wish to add into their cart
 * @author FDAB 2
 * @version 1.0
 */
class MenuPage {
    private Scanner sc;
    
    /**
     * All food items available in the menu
     */
    private ArrayList<Item> menu;
    
    /**
     * Cart management class to edit,remove and add to customer's cart
     */
    private CartManagement cartManagement;

    
    /**
     * Base Constructor 
     */
    MenuPage() {
    	
    }
    
    /**
     * <li>Constructor of the Menupage class, creating the object will begin the MenuPage UI , where customers have the option to choose ton add a menu item to the cart
     * @param sc scanner object
     * @param menu Menu displaying all food items available to customer
     * @param cart Cart of the current customer interacting with the Menu 
     */
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

    
    /**
     * <li>Method will display all Menu items in the branch 
     */
    private void displayMenu() {
        System.out.println("---MENU---");
        System.out.println("ID\t\t\tName\t\t\tPrice\t\t\tCategory\t\t\tDescription");
        for (Item item: this.menu) {
            System.out.println(item.getId() + "\t\t\t" + item.getName() + "\t\t\t" + item.getPrice() + 
            		"\t\t\t" + item.getCategory() + "\t\t\t" + item.getDescription());
        }
        System.out.println();
    }

    
    /**
     * <li>Method serves as a sub-page UI for customers to choose their food item using foodID and input the amount that they wish to purchase
     * <li>The method will call the corresponding method to ass these items into the customer Cart
     */
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
