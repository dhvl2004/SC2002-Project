package application.customerui;

import java.util.InputMismatchException;
import java.util.Scanner;

import cart.Cart;
import cart.CartItem;
import cart.CartManagement;
import exception.InputOutOfRange;
import item.Item;

class CartPage {
    private Scanner sc;
    private Cart cart;
    private CartManagement cartManagement;

    CartPage(Scanner sc, Cart cart) {
        this.sc = sc;
        this.cart = cart;
        this.cartManagement = new CartManagement(cart);
        System.out.println("Please enter your action:");
        System.out.println("1. Display Cart");
        System.out.println("2. Edit Item in Cart");
        System.out.println("3. Remove Item from Cart");
        System.out.println("4. Clear Cart");
        System.out.println("5. Go Back");
        int cartActionChoice = sc.nextInt();
        try {
            switch (cartActionChoice) {
                case 1:
                    this.displayCart();
                    break;
                case 2:
                    this.editCartItem();
                    break;
                case 3:
                    this.removeCartItem();
                    break;
                case 4:
                    this.cart.clearCart();
                    break;
                case 5:
                    return;
                default:
                    throw new InputOutOfRange();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            sc.next();
        }
        catch (InputOutOfRange e) {
            System.out.println("Invalid input.");
        }
        finally {
            System.out.println();
        }
    }

    private void displayCart() {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Cart Items:");
        for (CartItem cartItem : this.cart.getCartItemList()) {
            System.out.println("Item ID:\t" + cartItem.getId());
            System.out.println("Name:\t" + cartItem.getName());
            System.out.println("Price:\t$" + cartItem.getPrice());
            System.out.println("Category:\t" + cartItem.getCategory());
            System.out.println("Quantity:\t" + cartItem.getQuantity());
            System.out.println();
        }
        System.out.println("Total Price: " + this.cart.getTotalPrice());
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println();
    }

    private void editCartItem() {
        System.out.println("---Edit Item from Cart---");
        System.out.print("Enter Item ID: ");
        String itemId = this.sc.next();
        CartItem editedCartItem = this.cartManagement.getCartItem(itemId);
        if (editedCartItem != null) {
            System.out.print("Enter new Quantity: ");
            int newQuantity = sc.nextInt();
            try {
                if (newQuantity < 0) {
                    throw new InputOutOfRange();
                }
                if (newQuantity == 0) {
                    this.cartManagement.removeCartItem(itemId);
                }
                else {
                    editedCartItem.setQuantity(newQuantity);
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                sc.next();
            }
            catch (InputOutOfRange e) {
                System.out.println("Invalid input.");
            }
            finally {
                System.out.println();
            }
            return;
        }
        System.out.println("Item ID not found!");
    }

    private void removeCartItem() {
        System.out.println("---Remove Item from Cart---");
        System.out.print("Enter Item ID: ");
        String itemId = this.sc.next();
        CartItem removedCartItem = this.cartManagement.getCartItem(itemId);
        if (removedCartItem != null) {
            this.cartManagement.removeCartItem(itemId);
            System.out.println(removedCartItem.getQuantity() + " " + removedCartItem.getName() + "(s) has been removed from your Cart!");
            return;
        }
        System.out.println("Item ID not found!");
    }
}
