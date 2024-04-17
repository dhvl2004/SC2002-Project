package item;
public class Item {
    String itemId;
    String itemName;
    double price;
    int quantity;
    String description;

    public Item(String itemId, String itemName, double price, int quantity, String description) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getItemId() {
        return this.itemId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getDescription() {
        return this.description;
    }
}

