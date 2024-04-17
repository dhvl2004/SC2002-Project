package order;

public class OrderProcessor {
    private Order order;

    public OrderProcessor(Order order) {
        this.order = order;
    }

    public boolean processOrder() {
        if (this.order == null || this.order.status == true) {
            return false;
        }

        this.order.status = true;
        return true;
    }
}
