package item;

public class StockEditor {
    private Item item;

    public StockEditor(Item item) {
        this.item = item;
    }

    public boolean addStock(int itemAmount) {
        if (this.item == null || itemAmount <= 0) {
            return false;
        }

        this.item.setQuantity(this.item.getQuantity() + itemAmount);
        return true;
    }

    public boolean removeStock(int itemAmount) {
        if (this.item == null || itemAmount <= 0 || this.item.getQuantity() < itemAmount) {
            return false;
        }

        this.item.setQuantity(this.item.getQuantity() - itemAmount);
        return true;
    }
}
