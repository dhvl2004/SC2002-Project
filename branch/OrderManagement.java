package branch;

public class OrderManagement {
    private Branch branch;

    public OrderManagement(Branch branch) {
        this.branch = branch;
    }

    public Order findOrder(int orderId) {
        for (int i = 0; i < this.branch.orderList.size(); i++) {
            if (orderId == this.branch.orderList.get(i).getOrderId()) return this.branch.orderList.get(i);
        }
        return null;
    }

    public boolean processOrder(int orderId) {
        Order order = findOrder(orderId);
        if (order == null) return false;
        order.processOrder();
        return true;
    }
}
