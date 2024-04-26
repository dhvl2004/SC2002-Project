package branch;

import order.Order;

/**
 * <li>Facilitates the manipulation of any customers orders in the branch
 * <li> This is different from "ItemManagement", where item management focused on all food items within the branch
 * <li> This class focuses on all orders made by customers within the branch, which also contain all food item along with their respective quantities
 * 
 * @author FDAB 2
 * @version 1.0 
 * 
 */
public class OrderManagement {
    private Branch branch;

    
    /**
     * Base constructor 
     * @param branch Branch whose orders will be manipulated
     */
    public OrderManagement(Branch branch) {
        this.branch = branch;
    }

    
    /**
     * Searches through all orders made in the branch and returns specified user's order
     * @param orderId orderID of the order to be returned
     * @return Order of customer that was made within the branch
     */
    public Order getOrder(String orderId) {
        for (Order order : this.branch.getOrderList()) {
            if (orderId.equals(order.getOrderId())) {
                return order;
            }
        }
        return null;
    }

    
    /**
     * <li>Adds a order to the branch
     * <li>Whether or not this order was made by a customer or an add-on by staff, method will still add it as an order made within the branch
     * @param order order to be added
     * @return <li>True if the order was successfully added
     * <li>False if the order already exist and hence cannot be added
     */
    public boolean addOrder(Order order) {
        if (getOrder(order.getOrderId()) != null) {
            return false;
        }
        
        this.branch.orderList.add(order);
        this.branch.increaseOrderId();
        return true;
    }

    
    /**
     * <li>Removes order from the branch
     * <li>This is different from removing an order from a customer
     * @param orderId order to be removed
     * @return <li> Order object if order was successfully removed
     * <li>NULL if order to be removed does not exist/cannot be found
     */
    public Order removeOrder(String orderId) {
        Order order = getOrder(orderId);
        if (order == null) {
            return null;
        }
        
        this.branch.orderList.remove(order);
        return order;
    }
}
