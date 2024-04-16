package item;

import branch.Branch;
import branch.ItemManagement;

public class ItemEditor {
    private Item item;

    public ItemEditor(Branch branch, String itemId) {
        ItemManagement itemManagement = new ItemManagement(branch);
        this.item = itemManagement.find(itemId);
    }

    public boolean editItemId(String newItemId) {
        if (this.item == null || newItemId == this.item.getItemId()) {
            return false;
        }

        this.item.itemId = newItemId;
        return true;
    }

    public boolean editItemPrice(double newPrice) {
        if (this.item == null || newPrice == this.item.getPrice()) {
            return false;
        }

        this.item.price = newPrice;
        return true;
    }

    public boolean editItemQuantity(int newQuantity) {
        if (this.item == null || newQuantity == this.item.getQuantity()) {
            return false;
        }

        this.item.quantity = newQuantity;
        return true;
    }

    public boolean editItemDescription(String newDescription) {
        if (this.item == null || newDescription == this.item.getDescription()) {
            return false;
        }

        this.item.description = newDescription;
        return true;
    }
}
