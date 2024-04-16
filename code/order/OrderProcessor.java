package order;

import branch.Branch;
import branch.OrderManagement;

public class OrderProcessor {
    private Order order;

    public OrderProcessor(Branch branch, String orderId) {
        OrderManagement orderManagement = new OrderManagement(branch);
        this.order = orderManagement.find(orderId);
    }

    public boolean processOrder() {
        if (this.order == null || this.order.status == true) {
            return false;
        }

        this.order.status = true;
        return true;
    }
}
