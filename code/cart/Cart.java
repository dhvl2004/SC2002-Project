package cart;

import java.util.ArrayList;

//=======================================================================
/*	Cart class	*/
// ======================================================================
public class Cart {
	
    protected ArrayList<CartItem> cartItemList;
    protected double totalPrice = 0;

    public Cart() {
        this.cartItemList = new ArrayList<CartItem>();
    }

    public ArrayList<CartItem> getCartItemList() {
        return cartItemList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isEmpty() {
        return cartItemList.isEmpty();
    }

    public void clearCart() {
        cartItemList.clear();
    }
}