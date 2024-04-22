package application.customerui;

import java.util.ArrayList;

import branch.Branch;
import order.Order;
import order.Order.OrderStatus;

class ViewingPage {
    ViewingPage (Branch branch) {
        ArrayList<Order> orderList = branch.getOrderList();
        System.out.println("List of Orders:");
        System.out.println("NEW:");
        for (Order order : orderList) {
            if (order.getOrderStatus() == OrderStatus.NEW) {
                System.out.println(order.getOrderId());
            }
        }
        System.out.println("READY TO PICK UP:");
        for (Order order : orderList) {
            if (order.getOrderStatus() == OrderStatus.READY_TO_PICKUP) {
                System.out.println(order.getOrderId());
            }
        }
    }
}
