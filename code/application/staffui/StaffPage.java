package application.staffui;

import java.util.ArrayList;
import java.util.Scanner;

import branch.Branch;
import branch.OrderManagement;
import order.Order;
import order.OrderDisplay;
import order.OrderProcessor;
import staff.Staff;
import order.Order.OrderStatus;

class StaffPage {
    private Branch branch;
    private ArrayList<Order> orderList;
    private OrderManagement orderManagement;
    private Staff staff;
    StaffPage(Scanner sc, Staff staff, Branch branch) {
        this.branch = branch;
        this.orderList = this.branch.getOrderList();
        this.orderManagement = new OrderManagement(this.branch);
        this.staff = staff;
        
        while (true) {
        	System.out.println("\n--------------------");
            System.out.println("LOGIN AS STAFF");
            System.out.println("--------------------");

            System.out.println("Choose your action:");
            System.out.println("1. Display new Orders");
            System.out.println("2. View the details of a particular Order");
            System.out.println("3. Process Order");
            System.out.println("4. Change Password");
            System.out.println("5. Return to Start");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("---Display new Orders---");
                    this.displayNewOrders();
                    break;
                case 2:
                    System.out.println("---View the details of a particular Order---");
                    System.out.print("Enter the Order ID: ");
                    String orderIdToView = sc.next();
                    this.viewOrder(orderIdToView);
                    break;
                case 3:
                    System.out.println("---Process Order---");
                    System.out.print("Enter the Order ID: ");
                    String orderIdToProcess = sc.next();
                    processOrder(orderIdToProcess);
                    break;
                case 4:
                	System.out.println("---Change Password---");
                	System.out.println("Enter Old Password: ");
                	String oldPassword = sc.next();
                	if (!oldPassword.equals(staff.getPassword())) {
                		System.out.println("Incorrect Old Password");
                		break;
                	}
                	System.out.println("Enter New Password: ");
                	String newPassword1 = sc.next();
                	System.out.println("Confirm New Password: ");
                	String newPassword2 = sc.next();
                	if (newPassword1.equals(newPassword2)) {
                		staff.setPassword(newPassword2);
                		System.out.println("Password has been changed");
                	}
                	else System.out.println("New passwords does not match");
                	break;
                case 5:
                    System.out.println("...Returning to Start...");
                    return;
                default:
                    break;
            }
//            return;
        }
    }

    private void displayNewOrders() {
    	if (this.orderList.isEmpty()) System.out.println("No pending orders");
        for (Order order : this.orderList) {
            if (order.getOrderStatus() == OrderStatus.NEW) {
                new OrderDisplay(order);
            }
        }
    }

    private void viewOrder(String orderId) {
        Order order = this.orderManagement.getOrder(orderId);
        if (order == null) {
            System.out.println("Order ID " + orderId + " not found.");
            return;
        }
        new OrderDisplay(this.orderManagement.getOrder(orderId));
    }

    private void processOrder(String orderId) {
        Order order = this.orderManagement.getOrder(orderId);
        if (order == null) {
            System.out.println("Order ID " + orderId + " not found.");
            return;
        }
        OrderProcessor orderProcessor = new OrderProcessor(order);
        if (orderProcessor.setReadyToPickup() == false) {
            System.out.println("Order ID " + orderId + " is already processed.");
        }
        else {
            System.out.println("Order ID " + orderId + " is processed successfully.");
        }

    }
}
