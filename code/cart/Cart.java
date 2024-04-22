package cart;

import java.util.ArrayList;

//=======================================================================
/*	Cart class	*/
// ======================================================================

/**
 * 
 * <li>This Class represents the All Cart items, including Type of Food Item and it's quantity</li>
 * @author FDAB 2
 * @version 1.0
 * @since 2024
 */
public class Cart {
	
	/**
	 * ArrayList containing an Array of FoodItems along with their Quantities
	 */
    protected ArrayList<CartItem> cartItemList;

    
    /**
     * <li> Constructor for the "Cart" Class</li>
     * <li> This creates an object that contains allFood Items currently in the Cart </li>
     */
    public Cart() {
        this.cartItemList = new ArrayList<CartItem>();
    }

    /**
     * Getter Method for Retrieving the ArrayList of CartItems 
     * @return Returns the ArrayList of Cart Items(Food Items and their Quantity)
     */
    public ArrayList<CartItem> getCartItemList() {
        return cartItemList;
    }

    
    /**
     * <li>Getter method for the total price of the Whole Cart</li>
     * <li> After Initializing totalPrice, This method sums the price of all Food Items Multiplied by their Quantity  </li>
     * @return A double Representing the Cost/Price of the Entire Cart
     */
    public double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem cartItem : cartItemList) {
            totalPrice += cartItem.getPrice() * cartItem.getQuantity();
        }
        return totalPrice;
    }

    /**
     * <li>Checks if the ArrayList of CartItems is empty or not</li>
     * <li>Returns 'true' if empty and 'false' if there are still items left in the Cart</li>
     * @return Returns a Boolean 'true' or 'false'
     */
    public boolean isEmpty() {
        return cartItemList.isEmpty();
    }

    /**
     * Method that clears the entire Cart
     */
    public void clearCart() {
        cartItemList.clear();
    }
}