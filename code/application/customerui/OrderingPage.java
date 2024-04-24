package application.customerui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import cart.Cart;
import exception.InputOutOfRangeException;
import item.Item;

class OrderingPage {
    private boolean checkedOut = false;
    private Cart cart = new Cart();

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

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public Cart getCart() {
        return cart;
    }
}
