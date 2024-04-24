package order;

import cart.CartItem;

public class OrderDisplay {
    public OrderDisplay(Order order) {
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("-------------");
        System.out.println("Item Ordered:");
        for (int i = 0; i < order.getItemOrdered().size(); i++) {
            CartItem cartItem = order.getItemOrdered().get(i);
            System.out.println(cartItem.getName());
        }
        System.out.println("-------------");
        System.out.println("Order Status:\t" + order.getOrderStatus().toString());
        System.out.println("Dining Option:\t" + order.getDiningOption().toString());
        System.out.println("Payment Mode:\t" + order.getPaymentMode());
    }
}