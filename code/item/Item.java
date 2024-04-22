package item;

/**
 * 
 * Class to represent an individual food item option
 * @author FDAB 2
 * @version 1.0
 * @since 2024
 */
public class Item {
	/**
	 * Enumeration Variable to determine Type of Food Item
	 */
    public enum Category {SIDE, SET_MEAL, BURGER, DRINK}
    
    /**
     * itemId identifies the food, as a string
     */
    private String itemId;
    /**
     * Name of the Food Item
     */
    private String name;
    /**
     * The Price of the Food Item
     */
    private double price;
    
    /**
     * Type of food Item 
     */
    private Category category;

    
    /**
     * <li>Constructor for a single Food Item</li>
     * <li>Creates a Item object that represents a single Food item</li>
     * @param itemId Id of the Food Item 
     * @param name Name of the Food Item
     * @param price Price of the food Item
     * @param category Type of the Food Item
     */
    public Item(String itemId, String name, double price, Category category) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    
    /**
     * Getter Method for retrieving Id of Food item 
     * @return Returns Id of the Food Item
     */
    public String getId() {
        return this.itemId;
    }

    
    /**
     * Getter Method for retrieving Name of Food item 
     * @return Returns Name of Food Item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter Method for retrieving Price of Food item 
     * @return Returns Name of Food Item
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Getter Method for retrieving Type of Food item 
     * @return Returns Type of Food Item
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Setter Method for Food ID
     * @param itemId Id of the Food Item
     */
    public void setId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * Setter Method for Food ID
     * @param name Name of Food Item 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter Method for Food ID
     * @param price Price of Food Item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Setter Method for Food ID
     * @param category Type of Food Item
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}

