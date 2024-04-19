package order;

import java.util.ArrayList;

import cart.CartItem;
import payment.PaymentMode;

public class Order {
    public enum OrderStatus {NEW, READY_TO_PICKUP, PICKED_UP};
    public enum DiningOption {DINE_IN, TAKEAWAY};

    private String orderId;
    private ArrayList<CartItem> itemOrdered;
    private OrderStatus orderStatus = OrderStatus.NEW;
    private DiningOption diningOption;
    private PaymentMode paymentMode;

    public Order(String orderId, ArrayList<CartItem> itemOrdered, DiningOption diningOption, PaymentMode paymentMode) {
        this.orderId = orderId;
        this.itemOrdered = itemOrdered;
        this.diningOption = diningOption;
        this.paymentMode = paymentMode;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public ArrayList<CartItem> getItemOrdered() {
        return this.itemOrdered;
    }

    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    public DiningOption getDiningOption() {
        return this.diningOption;
    }

    public PaymentMode getPaymentMode() {
        return this.paymentMode;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
