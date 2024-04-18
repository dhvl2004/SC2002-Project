package application.customerui;

import java.util.Scanner;

import cart.Cart;

class CartPage {
    CartPage(Scanner sc, Cart cart) {
        cart.displayCart();
        System.out.println("Please enter your action:");
        System.out.println("1. Edit Item in Cart");
        System.out.println("2. Remove Item from Cart");
        System.out.println("3. Go Back");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                
                break;
            case 2:
                break;
            case 3:
                return;
            default:
                return;
        }
    }
}
