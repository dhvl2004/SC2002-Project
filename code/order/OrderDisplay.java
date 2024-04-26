package order;

import cart.CartItem;


/**
 * <li>Class for printing onto UI all items ordered by customer\
 * <li> This includes the type,name,quantity,price and description of the food items 
 */
public class OrderDisplay {
	
	/**
	 * Constructor class 
	 * <li>Upon Instantiation all food item within a single order will be displayed on the Customer UI
	 * @param order The order representing a single order by a customer
	 */
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