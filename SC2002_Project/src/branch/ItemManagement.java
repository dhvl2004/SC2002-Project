package branch;

import item.Item;

public class ItemManagement {
    private Branch branch;

    public ItemManagement(Branch branch) {
        this.branch = branch;
    }

    public Item getItem(String itemId) {
        for (Item item : this.branch.getItemList()) {
            if (itemId.equals(item.getId())) {
                return item;
            }
        }
        return null;
    }

    public boolean addItem(Item item) {
        if (getItem(item.getId()) != null) {
            return false;
        }
        
        this.branch.itemList.add(item);
        return true;
    }

    public Item removeItem(String itemId) {
        Item item = getItem(itemId);
        if (item == null) {
            return null;
        }
        
        this.branch.itemList.remove(item);
        return item;
    }
}
