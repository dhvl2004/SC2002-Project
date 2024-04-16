package branch;

import order.Order;

public class OrderManagement {
    private Branch branch;

    public OrderManagement(Branch branch) {
        this.branch = branch;
    }

    public Order find(String orderId) {
        Order order = null;
        for (int i = 0; i < this.branch.orderList.size(); i++) {
            if (orderId == this.branch.orderList.get(i).getOrderId()) {
                order = this.branch.orderList.get(i);
                break;
            }
        }
        return order;
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
