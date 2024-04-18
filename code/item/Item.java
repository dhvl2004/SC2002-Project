package item;
public class Item {
    public enum Category {SIDE, SET_MEAL, BURGER, DRINK}
    private String itemId;
    private String name;
    private double price;
    private Category category;

    public Item(String itemId, String name, double price, Category category) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.category = category;
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

    public Category getCategory() {
        return category;
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

    public void setCategory(Category category) {
        this.category = category;
    }
}

