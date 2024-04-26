package branch;

import item.Item;


/**
 * <li>This class allows for adding,removing and editing of any item within the Branch
 * <li>This is to be differentiated from a customer editing their own cart items,this class interacts with the branch as a totality
 */
public class ItemManagement {
    private Branch branch;

    
    /**
     * Constructor for ItemMangement
     * @param branch Current branch that will edit item
     */
    public ItemManagement(Branch branch) {
        this.branch = branch;
    }

    
    /**
     * Scan through all items currently in the branch and Retrieves item within the branch
     * @param itemId ID of the food item
     * @return returns the item object represented the identified item
     */
    public Item getItem(String itemId) {
        for (Item item : this.branch.getItemList()) {
            if (itemId.equals(item.getId())) {
                return item;
            }
        }
        return null;
    }

    
    /**
     * Add item to the branch's list o f food item
     * <li>This method does not in anyway affect customer's orders and their own list of food items
     * <li> The 2 list of food items are separate
     * @param item Food item to be added
     * @return <li>True if item was added successfully
     *         <li> False if item to be added already exists within the branch
     */
    public boolean addItem(Item item) {
        if (getItem(item.getId()) != null) {
            return false;
        }
        
        this.branch.itemList.add(item);
        return true;
    }

    
    /**
     * <li>Removes item from the list of food items of the Branch
     * <li>This method does not in anyway affect customer's orders and their own list of food items
     * <li> The 2 list of food items are separate
     * @param itemId Food item to be removed
     * @return <li>Null if food item does not exist
     *         <li>Removed Food Item if the item is successfully removed
     */
    public Item removeItem(String itemId) {
        Item item = getItem(itemId);
        if (item == null) {
            return null;
        }
        
        this.branch.itemList.remove(item);
        return item;
    }
}
