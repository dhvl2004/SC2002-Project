package cart;

import java.util.ArrayList;

//=======================================================================
/*	Cart class	*/
// ======================================================================
public class Cart {
	
    protected ArrayList<CartItem> cartItemList;
    protected double totalPrice = 0;

    public Cart() {
        this.cartItemList = new ArrayList<CartItem>();
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

    /* Should the items within the list be identified with itemId? */
    public void editCartItem(String itemId, int newQuantity) {
            cartItemList.setQuantity(newQuantity);
            System.out.println("Invalid itemId. Please choose a valid itemId.");
    }

    public void clearCart() {
        cartItemList.clear();
    }
}