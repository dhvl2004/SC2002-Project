package item;
public class Item {
    private String itemId;
    private String name;
    private double price;
    private int quantity;
    private String description;

    public Item(String itemId, String name, double price, int quantity, String description) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getId() {
        return this.itemId;
    }

    public String getName() {
        return this.name;
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

    public void setId(String itemId) {
        this.itemId = itemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

