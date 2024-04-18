package cart;

import java.util.ArrayList;

//=======================================================================
/*	Cart class	*/
// ======================================================================
public class Cart {
	
    ArrayList<CartItem> cartItemList;
    double totalPrice = 0;

    public Cart() {
        this.cartItemList = new ArrayList<>();
    }

    public ArrayList<CartItem> getCartItemList() {
        return cartItemList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isEmpty() {
        return cartItemList.isEmpty();
    }

    public void displayCart() {
    	System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Cart Items:");
        for (int i=0; i<cartItemList.size(); i++) {
            CartItem cartItem = cartItemList.get(i);
            System.out.println("Item " + (i + 1) + ":");
            System.out.println("Item ID: " + cartItem.getId());
            System.out.println("Name: " + cartItem.getName());
            System.out.println("Price: $" + cartItem.getPrice());
            System.out.println("Category: " + cartItem.getCategory());
            System.out.println("Quantity: " + cartItem.getQuantity());
            System.out.println();
        }
        System.out.println("Total Price: " + this.totalPrice);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println();
    }

    /* Should the items within the list be identified with itemId? */
    public void editCartItem(int itemId, int newQuantity) {
        if (itemId >= 0 && itemId < cartItemList.size())
            cartItemList.get(itemId).setQuantity(newQuantity);
        else
            System.out.println("Invalid itemId. Please choose a valid itemId.");
    }

    public void clearCart() {
        cartItemList.clear();
    }
}