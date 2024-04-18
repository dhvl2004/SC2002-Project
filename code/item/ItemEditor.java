package item;

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

    public boolean editQuantity(int quantity) {
        if (this.item == null || quantity == this.item.getQuantity()) {
            return false;
        }

        this.item.setQuantity(quantity);
        return true;
    }

    public boolean editDescription(String description) {
        if (this.item == null || description == this.item.getDescription()) {
            return false;
        }

        this.item.setDescription(description);
        return true;
    }
}
