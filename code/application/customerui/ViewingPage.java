package application.customerui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import branch.Branch;
import branch.OrderManagement;
import exception.InputOutOfRangeException;
import order.Order;
import order.OrderProcessor;
import order.Order.OrderStatus;

class ViewingPage {
    ViewingPage (Scanner sc, Branch branch) {
        ArrayList<Order> orderList = branch.getOrderList();
        System.out.println("List of Orders:");
        System.out.println("NEW:");
        for (Order order : orderList) {
            if (order.getOrderStatus() == OrderStatus.NEW) {
                System.out.println(order.getOrderId());
            }
        }
        System.out.println();
        System.out.println("READY TO PICK UP:");
        for (Order order : orderList) {
            if (order.getOrderStatus() == OrderStatus.READY_TO_PICKUP) {
                System.out.println(order.getOrderId());
            }
        }
        System.out.println();
        System.out.println("Do you want to pick up an order?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter your choice: ");
        int pickUpChoice = sc.nextInt();
        System.out.println();
        try {
            switch (pickUpChoice) {
                case 1:
                    System.out.print("Enter order ID: ");
                    String orderId = sc.next();
                    for (Order order : orderList) {
                        if (order.getOrderId() == orderId) {
                            if (order.getOrderStatus() == OrderStatus.READY_TO_PICKUP) {
                                order = new OrderManagement(branch).getOrder(orderId);
                                new OrderProcessor(order).setPickedUp();
                                System.out.println("Pick up successfully!");
                                return;
                            }
                            System.out.println("Your order is not ready to pick up!");
                            return;
                        }
                    }
                case 2:
                    return;
                default:
                    throw new InputOutOfRangeException();
            }
        } catch (InputOutOfRangeException e) {
            System.out.println("Invalid Input");
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
            sc.next();
        }
    }
}
