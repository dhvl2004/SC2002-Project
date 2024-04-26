package application.customerui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import cart.Cart;
import exception.InputOutOfRangeException;
import item.Item;


/**
 * <li>Class serves as a UI Page for Customer to decide to checkout or return to ordering UI
 * <li>Class will also facilitate the checking out of customer's order and directing customer to Payment UI
 * @author FDAB 2
 * @version 1.0
 */
class OrderingPage {
    private boolean checkedOut = false;
    
    /**
     * Cart of current customer's order
     */
    private Cart cart = new Cart();

    
    /**
     * <li>Constructor of OrderingPafe UI. Creating object would create a UI page for a single customer to interact with.
     * <li>Depending on Customer's decision the method will direct customer to the previous Menu UI page or the subsequent UI page for payment
     * <li> The method will also print error statements and throw exceptions if cart does not have any items or if customer input is invalid
     * @param sc scanner object
     * @param menu Menu of the food items 
     */
    OrderingPage(Scanner sc, ArrayList<Item> menu) {
        while (true) {
            System.out.println("Please choose your action:");
            System.out.println("1. Go to Menu");
            System.out.println("2. Go to Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Go Back");
            System.out.print("Enter your choice: ");
            try {
                int customerActionChoice = sc.nextInt();
                System.out.println();
                switch (customerActionChoice) {
                    case 1:
                        new MenuPage(sc, menu, this.cart);
                        break;
                    case 2:
                        new CartPage(sc, this.cart);
                        System.out.println("");
                        break;
                    case 3:
                        if (this.cart.isEmpty()) {
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

    
    /**
     * Method to determine if the Customer has checked out or not
     * @return <li>True: customer has checked out
     * <li>False: Customer has not checked out 
     */
    public boolean isCheckedOut() {
        return checkedOut;
    }

    
    /**
     * Getter method for retrieving the Cart of the current Customer interacting with this UI Page
     * @return Cart Object of the customers orders
     */
    public Cart getCart() {
        return cart;
    }
}
