package cart;


/**
 * 
 * This Class is to facilitate "retrieving","adding" and "removing" Food items on the user's Cart
 * @author FDAB 2
 * @version 1.0
 * @since 2024
 */
public class CartManagement {
	
	/**
	 * Attribute that represents the User's Cart
	 */
    private Cart cart;

    
    /**
     * <li>Constructor for CartManagement..</li>
     * <li> This creates an object 'CartManagement' that allows users to customize their Cart </li>
     * @param cart Takes in the User's Current Cart
     */
    public CartManagement(Cart cart) {
        this.cart = cart;
    }

    
    /**
     * This method takes in Specified Food Id and return the Food's CartItem(Food Item and Amount)
     * @param itemId Id of Food Item
     * @return Cart Item object of specific food
     */
    public CartItem getCartItem(String itemId) {
        for (CartItem cartItem: this.cart.cartItemList) {
            if (itemId.equals(cartItem.getId())) {
                return cartItem;
            }
        }
        return null;
    }

    /**
     * Method helps to add a new CartItem to the User's Cart
     * @param newCartItem A new Food item to be added into the Cart
     */
    public void addCartItem(CartItem newCartItem) {
        for (CartItem cartItem: this.cart.cartItemList) {
            if (newCartItem.getId() == cartItem.getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + newCartItem.getQuantity());
                return;
            }
        }
        this.cart.cartItemList.add(newCartItem);
    }

    
    /**
     * Method Removes item on the User's Cart
     * @param itemId Specific Food Item's Id to be remove
     * @return returns the removed CartItem
     */
    public CartItem removeCartItem(String itemId) {
        CartItem cartItem = getCartItem(itemId);
        if (cartItem == null) {
            return null;
        }
        this.cart.cartItemList.remove(cartItem);
        return cartItem;
    }
}
