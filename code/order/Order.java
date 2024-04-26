package order;

import java.util.ArrayList;

import cart.CartItem;

/**
 * <li>Class representing orders of customers
 * <li>The class's main goal is to consolidate all food items and requests by a customer's order so that staff can process the order
 * <li> The object interacts is of "entity" stereotype and interacts with staff, customer and manager when is comes to adding or processing the order
 * @author FDAB 2\
 * @version 1.0 
 * 
 */
public class Order {
	
	/**
	 * OrderStatus represents the 3 different state of customer order:New,Ready to collect , and Collected
	 */
    public enum OrderStatus {NEW, READY_TO_PICKUP, PICKED_UP};
    /**
     * Dining option represents the 2 dining options available to the customer
     */
    public enum DiningOption {DINE_IN, TAKEAWAY};
    
    /**
     * Payment mode represents the 2 current available payment mode for customers: online and Card
     */
    public enum PaymentMode {ONLINE, CARD};

    /**
     * OrderID is the identifier for a specific order by a customer
     */
    private String orderId;
    
    /**
     * itemOrdered is an Arraylist that contains all food items ad their quantity ordered by the customer
     */
    private ArrayList<CartItem> itemOrdered;
    
    private OrderStatus orderStatus = OrderStatus.NEW;
    private DiningOption diningOption;
    private PaymentMode paymentMode;

    
    /**
     * <li>Constructor for Order class, object instantiation represents a single order by a customer 
     * @param orderId OrderId unique to each customer's order
     * @param itemOrdered ArrayList of all food items ordered by the customer 
     * @param diningOption Represents the customers dining option 
     * @param paymentMode Represents the customers chosen payment mode
     */
    public Order(String orderId, ArrayList<CartItem> itemOrdered, DiningOption diningOption, PaymentMode paymentMode) {
        this.orderId = orderId;
        this.itemOrdered = itemOrdered;
        this.diningOption = diningOption;
        this.paymentMode = paymentMode;
    }

    
    /**
     * Getter method for OrderID 
     * @return OrderID identifying customer's order
     */
    public String getOrderId() {
        return this.orderId;
    }

    
    /**
     * Getter method for arraylist of Food items 
     * @return arrayList of CartItem, representing customer's food items ordered
     * 
     */
    public ArrayList<CartItem> getItemOrdered() {
        return this.itemOrdered;
    }

    
    /**
     * Getter method for Order status
     * @return OrderStatus identifying customer order's state(ready to collect or not)
     */
    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    
    /**
     * Getter method for Dining Option 
     * @return DiningOption object that represents customer dining option(eat-in or takeaway)
     */
    public DiningOption getDiningOption() {
        return this.diningOption;
    }

    
    /**
     * Getter method for Payment mode
     * @return PaymenMode object identifying customer's payment preference
     */
    public PaymentMode getPaymentMode() {
        return this.paymentMode;
    }

    
    /**
     * Setter method for changing the order's status
     * @param orderStatus The current state of the order
     */
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
