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


/**
 * <li>Class is meant to represent a UI where ALL customers are able to view and see if their order is still being prepared or if their order is ready for collection
 * <li> Class also facilitates the picking up of customers orders if it is ready to be collected
 * @author FDAB 2
 * @version 1.0
 */
class ViewingPage {
	
	
	/**
	 * <li>Constructor of ViewingPage Class, creating the object will create a UI for customers to see if their order is read for collection
	 * <li> Customers can choose to collect their order on this UI by giving their orderID that was generated in the previous UI Page: "ReceiptPrintingPage"
	 * <li>Error message and exceptions are thrown if : 
	 * <ul>
	 * 		<li> 1.Customer tries to collect order before it is ready 
	 * 		<li> 2.Order is not found
	 * 		<li> 3.Input from Customer is invalid
	 * </ul>
	 * @param sc Scanner Object
	 * @param branch Branch that the customer is going to collect their order from 
	 */
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
                        if (order.getOrderId().equals(orderId)) {
                            if (order.getOrderStatus().equals(OrderStatus.READY_TO_PICKUP)) {
                                order = new OrderManagement(branch).getOrder(orderId);
                                new OrderProcessor(order).setPickedUp();
                                System.out.println("Pick up successfully!");
                                return;
                            }
                            System.out.println("Your order is not ready to pick up!");
                            return;
                        }
                    }
                    System.out.println("Order not found!");
                    return;
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
