package item;

import item.Item.Category;


/**
 * <li>Class facilitates the editing of a food item
 * <li>Attributes of the food items that can be changed are : ID,Name,Price and Category
 * @author FDAB 2
 * @version 1.0 
 */
public class ItemEditor {
	
	/**
	 * The item object(singular food item) to be edit
	 */
    private Item item;

    /**
     * constructor for Item editor class
     * @param item Fod item to be edited
     */
    public ItemEditor(Item item) {
        this.item = item;
    }

    
    /**
     *<li>Facilitates changing of itemID of a particular food item
     * @param itemId The indentifier of the food item
     * @return <li>True if itemID has been changed 
     *         <li>False if no such item exist or if new itemID is same as original itemID
     */
    public boolean editId(String itemId) {
        if (this.item == null || itemId == this.item.getId()) {
            return false;
        }

        this.item.setId(itemId);
        return true;
    }
    

    
    /**
     * Facilitate changing price of a food item
     * @param price New price of the food item
     * @return <li>True if Price has been changed 
     *         <li>False if no such item exist or if new Price is same as original Price,
     */
    public boolean editPrice(double price) {
        if (this.item == null || price == this.item.getPrice()) {
            return false;
        }

        this.item.setPrice(price);
        return true;
    }

    
    /**
     * Facilitate changing category of a food item
     * <li> Category represents drink,snacks,main,etc.
     * @param category The new category of the food item
     * @return <li>True if Category has been changed 
     *         <li>False if no such item exist or if new Category is same as original Category
     */
    public boolean editCategory(Category category) {
        if (this.item == null || category == this.item.getCategory()) {
            return false;
        }

        this.item.setCategory(category);
        return true;
    }
}
