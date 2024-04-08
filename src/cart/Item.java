package cart;

public class Item {
    private int itemId;
    private double price;
    private int quantity;
    private String description;

    public Item(int itemId, double price, int quantity, String description) {
        this.itemId = itemId;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public int getItemId() {
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

    public void setItemId(int newItemId) {
        this.itemId = newItemId;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public void addStock(int itemAmount) {
        if (itemAmount <= 0) // throw error if num is not positive
        this.quantity += itemAmount;
    }

    public boolean removeStock(int itemAmount) {
        if (itemAmount <= 0) // throw error if num is not positive
        if (this.quantity < itemAmount) return false;
        this.quantity -= itemAmount;
        return true;
    }
}
