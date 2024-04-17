package project;

public class Item {
	private int itemId;
	private String name;
	private double price;
	private String branch;
	private String category;
	private int quantity;
	private String description;
	
	protected Item(int itemId, String name, double price, String branch, String category, int quantity, String description) {
		this.itemId = itemId;
		this.name = name;
		this.price = price;
		this.branch = branch;
		this.category = category;
		this.quantity = quantity;
		this.description = description;
	}
	
	public int getItemId() {
		return itemId;
	}
	
	public String getItemName() {
		return name;
	}
	
	public double getItemPrice() {
		return price;
	}
	
	public String getItemBranch() {
		return branch;
	}

	public String getItemCategory() {
		return category;
	}
	
	public int getItemQuantity() {
		return quantity;
	}
	
	public String getItemDescription() {
		return description;
	}
	
}
