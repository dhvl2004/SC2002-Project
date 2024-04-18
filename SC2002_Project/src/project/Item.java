package project;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Item {
	private int itemId;
	private String name;
	private double price;
	private String branch;
	private String category;
	private int quantity;
	private String description;
	
	public static Set<Item> itemSet = new LinkedHashSet<>();
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemId == item.itemId &&
                Double.compare(item.price, price) == 0 &&
                quantity == item.quantity &&
                Objects.equals(name, item.name) &&
                Objects.equals(branch, item.branch) &&
                Objects.equals(category, item.category) &&
                Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, price, branch, category, quantity, description);
    }
	
	public static void printItems() {
		if (itemSet.isEmpty()) System.out.println("No items found");
		
		for (Item item : itemSet) {
			System.out.println("Item{ItemId:" + item.getItemId() + 
					", Name:\"" + item.getItemName() + 
					"\", Price:" + item.getItemPrice() + 
					", Branch:\"" + item.getItemBranch() + 
					"\", Category:\"" + item.getItemCategory() + 
					"\", Quantity:" + item.getItemQuantity() + 
					", Description:\"" + item.getItemDescription() + 
					"\"}");
		}
	}
		
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
