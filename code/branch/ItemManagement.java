package branch;

import java.util.ArrayList;

import item.Item;

public class ItemManagement {
    private ArrayList<Item> itemList;

    public ItemManagement(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public Item find(String itemId) {
        for (Item item : this.itemList) {
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
        
        this.itemList.add(item);
        return true;
    }

    public Item remove(String itemId) {
        Item item = this.find(itemId);
        if (item == null) {
            return null;
        }
        
        this.itemList.remove(item);
        return item;
    }
}

