package application.customerui;

import java.util.InputMismatchException;
import java.util.Scanner;

import cart.Cart;
import cart.CartItem;
import cart.CartManagement;
import exception.InputOutOfRangeException;


/**
 * 
 * 
 * <li>The Class Displays User Interface for Cart</li>
 * <li>The Class will Display,Edit,Clear and Remove items in the cart according to user's preference</li>
 * 
 * @author FDAB 2
 * @version 1.0
 * @since 2024
 * 
 */
class CartPage {
	
	/**
	 * Scanner Object
	 */
    private Scanner sc;
    
    /**
     * This is the Cart the CartPage UI is representing
     */
    private Cart cart;
    
    /**
     * This is the current CartManagement Class for Customizing current Cart
     */
    private CartManagement cartManagement;

    
    /**
     * <li>Constructor for CartPage, creates a CartPage Object that is used by "CustomerInterface" class.</li>
     * <li>Displays User Interface for Cart and Cart Customization</li>
     * @param sc Scanner Object
     * @param cart Cart object containing User's current items                        
     */
    CartPage(Scanner sc, Cart cart) {
        this.sc = sc;
        this.cart = cart;
        this.cartManagement = new CartManagement(cart);
        System.out.println("---CART---");
        this.displayCart();
        System.out.println("Please enter your action:");
        System.out.println("1. Edit Item in Cart");
        System.out.println("2. Remove Item from Cart");
        System.out.println("3. Clear Cart");
        System.out.println("4. Go Back");
        int cartActionChoice = sc.nextInt();
        try {
            switch (cartActionChoice) {
                case 1:
                    this.editCartItem();
                    break;
                case 2:
                    this.removeCartItem();
                    break;
                case 3:
                    this.cart.clearCart();
                    break;
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

    /**
     * Function that displays(prints) all current items in the User's Cart
     */
    private void displayCart() {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Cart Items:");
        for (CartItem cartItem : this.cart.getCartItemList()) {
            System.out.println("Item ID:\t" + cartItem.getId());
            System.out.println("Name:\t" + cartItem.getName());
            System.out.println("Price:\t$" + Math.round(cartItem.getPrice() * 100) / 100);
            System.out.println("Category:\t" + cartItem.getCategory());
            System.out.println("Quantity:\t" + cartItem.getQuantity());
            System.out.println();
        }
        System.out.println("Total Price: " + this.cart.getTotalPrice());
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println();
    }

    
    /**
     * <li>Function that allows Users to Change the amount of the specified Food item in their Cart </li>
     * <li>Throws error Message if Id or Quantity to change is Invalid
     */
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
                    throw new InputOutOfRangeException();
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
            catch (InputOutOfRangeException e) {
                System.out.println("Invalid input.");
            }
            finally {
                System.out.println();
            }
            return;
        }
        System.out.println("Item ID not found!");
    }

    
    /**
     * <li> Removes the Food Item specified by Food ID</li>
     * <li> Throws error message if Food ID is invalid</li>
     */
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
