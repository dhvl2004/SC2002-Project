package project;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Iterator;

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
	

	public static void printItemsBranch(String branchLocation) {
		//doesnt check if the itemSet is empty for the specified location
		if (itemSet.isEmpty()){
			System.out.println("Sorry, there are currently no items on " + branchLocation + "'s menu. ");
		}
		else {
			System.out.println(branchLocation + " has the following items on the menu: ");
			int i = 1;
			for (Iterator<Item> it = itemSet.iterator(); it.hasNext(); ) {
				Item itemObj = it.next();
				if (itemObj.getItemBranch().equals(branchLocation)) {
	                System.out.printf("%d. Name: %-15s  Price: %.2f  Category: %-10s Quantity: %d  Description: %-25s%n",
	                				  i,
									  itemObj.getItemName(),
									  itemObj.getItemPrice(),
									  itemObj.getItemCategory(),
									  itemObj.getItemQuantity(),
									  itemObj.getItemDescription());
	                i++;
				}
			}
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
