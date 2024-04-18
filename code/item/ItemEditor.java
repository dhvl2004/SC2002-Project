package item;

import item.Item.Category;

public class ItemEditor {
    private Item item;

    public ItemEditor(Item item) {
        this.item = item;
    }

    public boolean editId(String itemId) {
        if (this.item == null || itemId == this.item.getId()) {
            return false;
        }

        this.item.setId(itemId);
        return true;
    }

    public boolean editPrice(double price) {
        if (this.item == null || price == this.item.getPrice()) {
            return false;
        }

        this.item.setPrice(price);
        return true;
    }

    public boolean editCategory(Category category) {
        if (this.item == null || category == this.item.getCategory()) {
            return false;
        }

        this.item.setCategory(category);
        return true;
    }
}
