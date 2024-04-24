package application.staffui;

import java.util.ArrayList;
import java.util.Scanner;

import branch.Branch;
import branch.ItemManagement;
import branch.OrderManagement;
import item.Item;
import order.Order;
import order.OrderDisplay;
import order.OrderProcessor;
import order.Order.OrderStatus;
import staff.Manager;
import staff.Staff;

class ManagerPage {
	private Branch branch;
    private ArrayList<Order> orderList;
    private OrderManagement orderManagement;
    
    ManagerPage(Scanner sc, Manager manager, Branch branch) {
        this.branch = branch;
        this.orderList = this.branch.getOrderList();
        this.orderManagement = new OrderManagement(this.branch);
        
        while (true) {
        	System.out.println("\n--------------------");
            System.out.println("LOGIN AS MANAGER");
            System.out.println("--------------------");

            System.out.println("Choose your action:");
            System.out.println("1. Display new Orders");
            System.out.println("2. View the details of a particular Order");
            System.out.println("3. Process Order");
            System.out.println("4. Change Password");
            System.out.println("5. Display Staff List");
            System.out.println("6. Add new menu item");
            System.out.println("7. Update menu item");
            System.out.println("8. Remove menu item");
            System.out.println("9. Return to Start");
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
                	if (!oldPassword.equals(manager.getPassword())) {
                		System.out.println("Incorrect Old Password");
                		break;
                	}
                	System.out.println("Enter New Password: ");
                	String newPassword1 = sc.next();
                	System.out.println("Confirm New Password: ");
                	String newPassword2 = sc.next();
                	if (newPassword1.equals(newPassword2)) {
                		manager.setPassword(newPassword2);
                		System.out.println("Password has been changed");
                	}
                	else System.out.println("New passwords does not match");
                	break;
                case 5:
                	displayStaffList();
                	break;
                case 6:
                	addNewMenuItem(sc);
                	break;
                case 7:
                	updateMenuItem(sc);
                	break;
                case 8:
                	removeMenuItem(sc);
                	break;
                case 9:
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
    
    private void displayStaffList() {
    	if (branch.getStaffList().isEmpty()) System.out.println("No staff found");
    	for (Staff staff : branch.getStaffList()) {
    		System.out.println("Name: " + staff.getName() + ", Gender: " + staff.getGender() + ", Age: " + staff.getAge());
    	}
    }
    
    private void addNewMenuItem(Scanner sc) {
    	System.out.println("Enter the following format:\nItemId,Name,Price,Category,Description");
    	if (sc.hasNextLine()) sc.nextLine();	// flush scanner
    	String itemString = sc.nextLine();
    	String[] itemParts = itemString.split(",");
    	if (itemParts.length != 5) {
    		System.err.println("Error adding new menu item: Invalid format");
    		return;
    	}
    	try {
    		String itemId = itemParts[0].trim();
        	String name = itemParts[1].trim();
        	Double price = Double.parseDouble(itemParts[2].trim());
        	String category = itemParts[3].trim().toUpperCase();
        	String description = itemParts[4].trim();
        	new ItemManagement(branch).addItem(new Item(itemId, name, price, category, description));
        	System.out.println(itemId + " added to menu");
    	} catch (NullPointerException e) {
    		System.err.println("Error adding new menu item: " + e.getMessage());
    	} catch (NumberFormatException e) {
    		System.err.println("Error adding new menu item: " + e.getMessage());
    	} catch (Exception e) {
    		System.err.println("Error adding new menu item: " + e.getMessage());
    	}
    }
    
    private void updateMenuItem(Scanner sc) {
    	System.out.println("---MENU---");
        System.out.println("ID\t\t\tName\t\t\tPrice\t\t\tCategory\t\t\tDescription");
        for (Item item: branch.getItemList()) {
            System.out.println(item.getId() + "\t\t\t" + item.getName() + "\t\t\t" + item.getPrice() + 
            		"\t\t\t" + item.getCategory() + "\t\t\t" + item.getDescription());
        }
        System.out.print("\nSelect Item ID: ");
        if (sc.hasNextLine()) sc.nextLine();
        String itemId = sc.next().trim();        
        Item item = findItem(itemId);
        if (item == null) {
        	System.out.println("Item not found");
        	return;
        }
        
        System.out.println("What do you want to update?");
		System.out.println("1. ID");
		System.out.println("2. Name");
		System.out.println("3. Price");
		System.out.println("4. Description");
		System.out.println("5. Cancel");
		int choice = sc.nextInt();
		if (sc.hasNextLine()) sc.nextLine();
		try {
			switch (choice) {
    			case 1:
    				System.out.println("Enter new ID: ");
    				String newId = sc.next().trim();
    				item.setId(newId);
    				System.out.println("ID updated");
    				break;
    			case 2:
    				System.out.println("Enter new Name: ");
    				String newName = sc.nextLine().trim();
    				item.setName(newName);
    				System.out.println("Name updated");
    				break;
    			case 3:
    				System.out.println("Enter new Price: ");
    				Double newPrice = sc.nextDouble();
    				item.setPrice(newPrice);
    				System.out.println("Price updated");
    				break;
    			case 4:
    				System.out.println("Enter new Description: ");
    				String newDescription = sc.nextLine().trim();
    				item.setDescription(newDescription);
    				System.out.println("Description updated");
    				break;
    			case 5:
				default:
    				return;
    		}
		} catch (Exception e) {
			System.err.println("Error updating item: " + e.getMessage());
		}
    }
    
    private void removeMenuItem(Scanner sc) {
    	System.out.println("---MENU---");
        System.out.println("ID\t\t\tName\t\t\tPrice\t\t\tCategory\t\t\tDescription");
        for (Item item: branch.getItemList()) {
            System.out.println(item.getId() + "\t\t\t" + item.getName() + "\t\t\t" + item.getPrice() + 
            		"\t\t\t" + item.getCategory() + "\t\t\t" + item.getDescription());
        }
        System.out.print("\nSelect Item ID: ");
        if (sc.hasNextLine()) sc.nextLine();
        String itemId = sc.next().trim();        
        Item item = findItem(itemId);
        if (item == null) {
        	System.out.println("Item not found");
        	return;
        }
        System.out.println(item.getId() + "\t\t\t" + item.getName() + "\t\t\t" + item.getPrice() + 
        		"\t\t\t" + item.getCategory() + "\t\t\t" + item.getDescription());
        System.out.println("Confirm remove?\n1. Yes\n2. No");
        if (sc.hasNextLine()) sc.nextLine();
        int choice = sc.nextInt();
        switch (choice) {
        	case 1:
        		new ItemManagement(branch).removeItem(itemId);
        		System.out.println("Item removed");
        		break;
        	case 2:
    		default:
    			return;
        }
    }
    
    private Item findItem(String itemId) {
    	ArrayList<Item> itemList = branch.getItemList();
    	if (itemList.isEmpty()) return null;
    	for (Item item : itemList) {
    		if (itemId.equals(item.getId())) return item;
    	}
    	return null;
    }
}
