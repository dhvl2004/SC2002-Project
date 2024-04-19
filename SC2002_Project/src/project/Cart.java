package project;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

public class Cart {
    public List<CartItem> itemList;
    
    public Cart() {
    	itemList = new ArrayList<CartItem>();
    }
    
    // should be passing in item specified by index from the menu browse
	public void addCartItem(Item item) {
		itemList.add(new CartItem(item.getItemName(), 
								  item.getItemPrice(), 
								  item.getItemCategory(), 
								  item.getItemQuantity(), 
								  item.getItemDescription()));
	}
	
    public void displayCartItems() {
    	System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Cart Items: ");
        for (int i=0; i<itemList.size(); i++) {
            CartItem cartItem = itemList.get(i);
            System.out.println("Item " + (i + 1) + ":");
            System.out.println("Name: " + cartItem.getItemName());
            System.out.println("Price: $" + cartItem.getItemPrice());
            System.out.println("Quantity: " + cartItem.getItemQuantity());
            System.out.println("Description: " + cartItem.getItemDescription());
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
    
    public void getTotalPrice() {
        double totalPrice = 0;
        for (CartItem cartItem : itemList) {
            totalPrice += cartItem.getItemPrice();
        }
        DecimalFormat priceFormatted = new DecimalFormat("#.##");
        System.out.println("The total price is: $ " + Double.parseDouble(priceFormatted.format(totalPrice)) );
    }

    
//    public void addItem(Item item, int quantity) {
//    	itemList.add(new CartItem(item.getItemId(), item.getItemPrice(), quantity, item.getItemDescription()));
//    }

    
//    /* Should the items within the list be identified with itemId? */
//    public void editItem(int itemId, int newQuantity) {
//        if (itemId >= 0 && itemId < itemList.size())
//            itemList.get(itemId).setQuantity(newQuantity);
//        else
//            System.out.println("Invalid itemId. Please choose a valid itemId.");
//    }
//
//    
//    /* Should the items within the list be identified with itemId? */
//    public void removeItem(int itemId) {
//        if (itemId >= 0 && itemId < itemList.size())
//            itemList.remove(itemId);
//        else
//            System.out.println("Invalid itemId. Please choose a valid itemId.");
//    }

    
    public void clearCart() {
        itemList.clear();
    }
}
