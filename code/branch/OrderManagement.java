package branch;

import order.Order;

public class OrderManagement {
    private Branch branch;

    public OrderManagement(Branch branch) {
        this.branch = branch;
    }

    public Order getOrder(String orderId) {
        for (Order order : this.branch.getOrderList()) {
            if (orderId.equals(order.getOrderId())) {
                return order;
            }
        }
        return null;
    }

    public boolean addOrder(Order order) {
        if (getOrder(order.getOrderId()) != null) {
            System.out.println("Order with ID " + order.getOrderId() + " already exists.");
            return false;
        }
        
        this.branch.orderList.add(order);
        System.out.println("Order added: " + order.getOrderId());
        return true;
    }

    public Order removeOrder(String orderId) {
        Order order = getOrder(orderId);
        if (order == null) {
            System.out.println("Order with ID " + orderId + " not found.");
            return null;
        }
        
        this.branch.orderList.remove(order);
        System.out.println("Order removed: " + orderId);
        return order;
    }
}
