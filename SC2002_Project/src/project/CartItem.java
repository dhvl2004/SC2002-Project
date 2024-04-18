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
	
	public String itemName() {
		return itemName;
	}
	
	public double itemPrice() {
		return itemPrice;
	}
	
	public String itemCategory() {
		return itemCategory;
	}
	
	public int itemQuantity() {
		return itemQuantity;
	}
	
	public String itemDescription() {
		return itemDescription;
	}
}