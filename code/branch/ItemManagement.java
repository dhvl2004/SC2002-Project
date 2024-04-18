package branch;

import item.Item;

public class ItemManagement {
    private Branch branch;

    public ItemManagement(Branch branch) {
        this.branch = branch;
    }

    public Item find(String itemId) {
        Item item = null;
        for (int i = 0; i < this.branch.itemList.size(); i++) {
            if (itemId == this.branch.itemList.get(i).getId()) {
                item = this.branch.itemList.get(i);
                break;
            }
        }
        return item;
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

