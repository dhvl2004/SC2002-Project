package order;

import order.Order.OrderStatus;


/**
 * <li>The class simulates the actual processing of the customer's order and making of the customer's order
 * <li>Hence this class will change the order status of the order
 */
public class OrderProcessor {
	
	/**
	 * The order of a customer
	 */
    private Order order;

    
    /**
     * Constructor for OrderProcessor
     * <li> Creates an object that can change the status of a customer's order
     * @param order Takes in the current customer order that will be processed
     */
    public OrderProcessor(Order order) {
        this.order = order;
    }

    
    /**
     * <li>This class allows customer order to be processed and represents this by changing order status of the order
     * @return <li>Returns True if order is successfully processed and hence order status is "Ready to Pick-Up"
     * 		   <li> Returns False if Order has no Food items, or if the order has already been processed
     */
    public boolean setReadyToPickup() {
        if (this.order == null || this.order.getOrderStatus() != OrderStatus.NEW) {
            return false;
        }

        this.order.setOrderStatus(OrderStatus.READY_TO_PICKUP);
        return true;
    }

    
    /**
     * <li> Method changes order status to picked up,meaning that the customer has already collected the order and hence the order can be purged from memory
     * 
     * @return <li>True if order is successfully picked up by customer
     *         <li>False if order does not exist or if has already been picked up 
     */
    public boolean setPickedUp() {
        if (this.order == null || this.order.getOrderStatus() != OrderStatus.READY_TO_PICKUP) {
            return false;
        }

        this.order.setOrderStatus(OrderStatus.PICKED_UP);
        return true;
    }
}
