package order;

import order.Order.OrderStatus;

public class OrderProcessor {
    private Order order;

    public OrderProcessor(Order order) {
        this.order = order;
    }

    public boolean setReadyToPickup() {
        if (this.order == null || this.order.getOrderStatus() != OrderStatus.NEW) {
            return false;
        }

        this.order.setOrderStatus(OrderStatus.READY_TO_PICKUP);
        return true;
    }

    public boolean setPickedUp() {
        if (this.order == null || this.order.getOrderStatus() != OrderStatus.READY_TO_PICKUP) {
            return false;
        }

        this.order.setOrderStatus(OrderStatus.PICKED_UP);
        return true;
    }
}
