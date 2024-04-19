package project;

public class CartItem {
	private String itemName;
	private double itemPrice;
	private String itemCategory;
	private int itemQuantity;
	private String itemDescription;
		
	public CartItem(String name, double price, String category, int quantity, String description) {
		this.itemName = name;
		this.itemPrice = price;
		this.itemCategory = category;
		this.itemQuantity = quantity;
		this.itemDescription = description;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public double getItemPrice() {
		return itemPrice;
	}
	
	public String getItemCategory() {
		return itemCategory;
	}
	
	public int getItemQuantity() {
		return itemQuantity;
	}
	
	public String getItemDescription() {
		return itemDescription;
	}
}