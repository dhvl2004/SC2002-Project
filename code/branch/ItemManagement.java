package branch;

import item.Item;

public class ItemManagement {
    private Branch branch;

    public ItemManagement(Branch branch) {
        this.branch = branch;
    }

    public Item find(String itemId) {
        for (Item item : this.branch.itemList) {
            if (itemId.equals(item.getId())) {
                return item;
            }
        }
        return null;
    }

    public boolean add(Item item) {
        if (this.find(item.getId()) != null) {
            return false;
        }
        
        this.branch.itemList.add(item);
        return true;
    }

    public Item remove(String itemId) {
        Item item = this.find(itemId);
        if (item == null) {
            return null;
        }
        
        this.branch.itemList.remove(item);
        return item;
    }
}

