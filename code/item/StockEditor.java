package item;

import branch.Branch;
import branch.ItemManagement;

public class StockEditor {
    private Item item;

    public StockEditor(Branch branch, String itemId) {
        ItemManagement itemManagement = new ItemManagement(branch);
        this.item = itemManagement.find(itemId);
    }

    public boolean addStock(int itemAmount) {
        if (this.item == null || itemAmount <= 0) {
            return false;
        }

        this.item.quantity += itemAmount;
        return true;
    }

    public boolean removeStock(int itemAmount) {
        if (this.item == null || itemAmount <= 0 || this.item.quantity < itemAmount) {
            return false;
        }

        this.item.quantity -= itemAmount;
        return true;
    }
}
