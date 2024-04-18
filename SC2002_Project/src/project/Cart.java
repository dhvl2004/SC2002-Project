package project;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

public class Cart {
    private List<CartItem> itemList;
    
    public Cart() {
    	itemList = new ArrayList<CartItem>();
    }
    
//    public List<CartItem> getCartItemList() {
//    	itemList = new ArrayList<CartItem>();
//    	return itemList;
//    }
	public void addCartItem() {
		itemList.add(null);
	}
	
    public void displayCartItems() {
    	System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Cart Items:");
        for (int i=0; i<itemList.size(); i++) {
            CartItem cartItem = itemList.get(i);
            System.out.println("Item " + (i + 1) + ":");
            System.out.println("Item ID: " + cartItem.getItemId());
            System.out.println("Price: $" + cartItem.getPrice());
            System.out.println("Quantity: " + cartItem.getQuantity());
            System.out.println("Description: " + cartItem.getDescription());
            System.out.println();
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println();
    }
    
//	  /* used double instead of float for precision   */
//    public float getTotalPrice() {
//        float totalPrice = 0;
//        for (Item item : itemList) {
//            totalPrice += item.getPrice() * item.getQuantity();
//        }
//        return totalPrice;
//    }
    
    public double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem cartItem : itemList) {
            totalPrice += cartItem.getPrice() * cartItem.getQuantity();
        }
        DecimalFormat priceFormatted = new DecimalFormat("#.##");
        return Double.parseDouble(priceFormatted.format(totalPrice));
    }

    
    public void addItem(Item item, int quantity) {
    	itemList.add(new CartItem(item.getItemId(), item.getItemPrice(), quantity, item.getItemDescription()));
    }

    
    /* Should the items within the list be identified with itemId? */
    public void editItem(int itemId, int newQuantity) {
        if (itemId >= 0 && itemId < itemList.size())
            itemList.get(itemId).setQuantity(newQuantity);
        else
            System.out.println("Invalid itemId. Please choose a valid itemId.");
    }

    
    /* Should the items within the list be identified with itemId? */
    public void removeItem(int itemId) {
        if (itemId >= 0 && itemId < itemList.size())
            itemList.remove(itemId);
        else
            System.out.println("Invalid itemId. Please choose a valid itemId.");
    }

    
    public void clearCart() {
        itemList.clear();
    }
}
