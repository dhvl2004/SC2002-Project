package branch;

import order.Order;

public class OrderManagement {
    private Branch branch;

    public OrderManagement(Branch branch) {
        this.branch = branch;
    }

    public Order find(String orderId) {
        for (Order order : this.branch.orderList) {
            if (orderId.equals(order.getOrderId())) {
                return order;
            }
        }
        return null;
    }

    public boolean add(Order order) {
        if (this.find(order.getOrderId()) != null) {
            return false;
        }
        
        this.branch.orderList.add(order);
        return true;
    }

    public Order remove(String orderId) {
        Order order = this.find(orderId);
        if (order == null) {
            return null;
        }
        
        this.branch.orderList.remove(order);
        return order;
    }
}

