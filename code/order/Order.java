package order;

import java.util.ArrayList;
import item.Item;

public class Order {
    public enum OrderStatus {NEW, READY_TO_PICKUP, PICKED_UP};
    public enum DiningOption {DINE_IN, TAKEAWAY};

    private String orderId;
    private ArrayList<Item> itemOrdered;
    private OrderStatus orderStatus = OrderStatus.NEW;
    private DiningOption diningOption;
    private int paymentMode;

    public Order(String orderId, ArrayList<Item> itemOrdered, DiningOption diningOption, int paymentMode) {
        this.orderId = orderId;
        this.itemOrdered = itemOrdered;
        this.diningOption = diningOption;
        this.paymentMode = paymentMode;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public ArrayList<Item> getItemOrdered() {
        return this.itemOrdered;
    }

    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    public DiningOption getDiningOption() {
        return this.diningOption;
    }

    public int getPaymentMode() {
        return this.paymentMode;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
