package branch;

import item.Item;

public class ItemManagement {
    private Branch branch;

    public ItemManagement(Branch branch) {
        this.branch = branch;
    }

    public Item findItem(int itemId) {
        for (int i = 0; i < this.branch.itemList.size(); i++) {
            if (itemId == this.branch.itemList.get(i).getItemId()) return this.branch.itemList.get(i);
        }
        return null;
    }

    public boolean addItem(int itemId, double price, int quantity, String description) {
        if (findItem(itemId) != null) return false;
        
        Item newItem = new Item(itemId, price, quantity, description);
        this.branch.itemList.add(newItem);
        return true;
    }

    public boolean editItem(int itemId, int newItemId, double newPrice, int newQuantity, String newDescription) {
        Item item = findItem(itemId);
        if (item == null) return false;
        ///

        ///
        return true;
    }

    public Item removeItem(int itemId) {
        Item item = findItem(itemId);
        this.branch.itemList.remove(item);
        return item;
    }

    public boolean addStock(int itemId, int itemAmount) {
        Item item = findItem(itemId);
        if (item == null) return false;
        item.addStock(itemAmount);
        return true;
    }

    public boolean removeStock(int itemId, int itemAmount) {
        Item item = findItem(itemId);
        if (item == null) return false;
        return item.removeStock(itemAmount);
    }
}
