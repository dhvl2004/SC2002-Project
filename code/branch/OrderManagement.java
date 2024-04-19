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
            return false;
        }
        
        this.branch.orderList.add(order);
        return true;
    }

    public Order removeOrder(String orderId) {
        Order order = getOrder(orderId);
        if (order == null) {
            return null;
        }
        
        this.branch.orderList.remove(order);
        return order;
    }
}
