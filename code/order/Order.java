package order;

import java.util.ArrayList;
import item.Item;

public class Order {
    private String orderId;
    private ArrayList<Item> itemOrdered;
    boolean status = false;
    private boolean isDiningIn;
    private int paymentType;

    public Order(String orderId, ArrayList<Item> itemOrdered, boolean isDiningIn, int paymentType) {
        this.orderId = orderId;
        this.itemOrdered = itemOrdered;
        this.isDiningIn = isDiningIn;
        this.paymentType = paymentType;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public ArrayList<Item> getItemOrdered() {
        return this.itemOrdered;
    }

    public boolean getStatus() {
        return this.status;
    }

    public boolean getIsDiningIn() {
        return this.isDiningIn;
    }

    public int getPaymentType() {
        return this.paymentType;
    }
}
