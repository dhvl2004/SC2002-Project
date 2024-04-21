package cart;

import item.Item;

public class CartItem extends Item {
    private int quantity;
    public CartItem(Item item, int quantity) {
        super(item.getId(), item.getName(), item.getPrice(), item.getCategory(), item.getDescription());
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
