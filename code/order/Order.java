package order;

import java.util.ArrayList;
import item.Item;

public class Order {
    public enum DiningOption {DINEIN, TAKEAWAY};

    private String orderId;
    private ArrayList<Item> itemOrdered;
    boolean status = false;
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

    public boolean getStatus() {
        return this.status;
    }

    public DiningOption getDiningOption() {
        return this.diningOption;
    }

    public int getPaymentMode() {
        return this.paymentMode;
    }
}
