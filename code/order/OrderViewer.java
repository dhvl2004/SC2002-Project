package order;

import item.Item;

public class OrderViewer {
    private Order order;
    

    public OrderViewer(Order order) {
        this.order = order;
    }

    public void viewOrder() {
        if (this.order == null) {
            System.out.println("Order not found!");
            return;
        }
        System.out.println("Order ID: " + this.order.getOrderId());
        System.out.println("-------------");
        System.out.println("Item Ordered\tAmount");
        for (int i = 0; i < this.order.getItemOrdered().size(); i++) {
            Item item = this.order.getItemOrdered().get(i);
            System.out.println(item.getItemName() + "\t" + item.getQuantity());
        }
        System.out.println("-------------");
        System.out.print("Order Status:\t" + this.order.getOrderStatus().toString());
        System.out.println("Dining Option:\t" + this.order.getDiningOption().toString());
        System.out.println("Payment Mode:\t" + this.order.getPaymentMode());
    }
}