package cart;

import java.util.ArrayList;

//=======================================================================
/*	Cart class	*/
// ======================================================================
public class Cart {
	
    protected ArrayList<CartItem> cartItemList;

    public Cart() {
        this.cartItemList = new ArrayList<CartItem>();
    }

    public ArrayList<CartItem> getCartItemList() {
        return cartItemList;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem cartItem : cartItemList) {
            totalPrice += cartItem.getPrice() * cartItem.getQuantity();
        }
        return totalPrice;
    }

    public boolean isEmpty() {
        return cartItemList.isEmpty();
    }

    public void clearCart() {
        cartItemList.clear();
    }
}