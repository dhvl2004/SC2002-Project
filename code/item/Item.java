package item;
public class Item {
    String itemId;
    double price;
    int quantity;
    String description;

    public Item(String itemId, double price, int quantity, String description) {
        this.itemId = itemId;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getItemId() {
        return this.itemId;
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

