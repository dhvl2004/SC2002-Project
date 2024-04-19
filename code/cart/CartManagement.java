package cart;

public class CartManagement {
    private Cart cart;

    public CartManagement(Cart cart) {
        this.cart = cart;
    }

    public CartItem getCartItem(String itemId) {
        for (CartItem cartItem: this.cart.cartItemList) {
            if (itemId.equals(cartItem.getId())) {
                return cartItem;
            }
        }
        return null;
    }

    public void addCartItem(CartItem newCartItem) {
        for (CartItem cartItem: this.cart.cartItemList) {
            if (newCartItem.getId() == cartItem.getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + newCartItem.getQuantity());
                return;
            }
        }
        this.cart.cartItemList.add(newCartItem);
    }

    public CartItem removeCartItem(String itemId) {
        CartItem cartItem = getCartItem(itemId);
        if (cartItem == null) {
            return null;
        }
        this.cart.cartItemList.remove(cartItem);
        return cartItem;
    }
}
