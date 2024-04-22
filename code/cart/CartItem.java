package cart;

import item.Item;


/**
 * 
 * Inherits the Item Class, this class also represents Food Items but not as a singular Quantity.
 * @author FDAB 2
 * @version 1.0
 * @since 2024
 */
public class CartItem extends Item {
	
	/**
	 * This attribute represents the amount/quantity of the Food Item
	 */
    private int quantity;
    
    /**
     * <li>Constructor for CartItem Object</li>
     * <li>This creates an object of a specific Food item along with it's quantity</li>
     * @param item The Specific Food Item Object
     * @param quantity The Quantity of the Food Item
     */
    public CartItem(Item item, int quantity) {
        super(item.getId(), item.getName(), item.getPrice(), item.getCategory());
        this.quantity = quantity;
    }

    /**
     * Getter Method for Amount/ quantity of a Food Item
     * @return The numeric Amount of a specific Food Item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *Setter Method for Setting the quantity of a Food item
     * @param quantity Takes an integer representing the quantity of a Food Item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
