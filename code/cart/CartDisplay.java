package cart;

public class CartDisplay {
    public CartDisplay(Cart cart) {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Cart Items:");
        for (int i=0; i< cart.getCartItemList().size(); i++) {
            CartItem cartItem = cart.getCartItemList().get(i);
            System.out.println("Item " + (i + 1) + ":");
            System.out.println("Item ID: " + cartItem.getId());
            System.out.println("Name: " + cartItem.getName());
            System.out.println("Price: $" + cartItem.getPrice());
            System.out.println("Category: " + cartItem.getCategory());
            System.out.println("Quantity: " + cartItem.getQuantity());
            System.out.println();
        }
        System.out.println("Total Price: " + cart.getTotalPrice());
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println();
    }
}
