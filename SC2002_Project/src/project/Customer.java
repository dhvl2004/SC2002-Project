package project;

import java.util.Scanner;
import java.io.IOException;

public class Customer {
	private int customerID;	//for collectFood (may not need)
	private Cart cart;
	
	public Customer() {
		cart = new Cart();
	}
	
    public void browseMenu(String branchLocation) {
		final String directory = System.getProperty("user.dir");
		String filename = directory + "/resources/menu_list(1).csv";
		try {
			ItemDB.loadItems(filename);
			Item.printItemsBranch(branchLocation);
			System.out.println();
		} 
		catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
			System.out.println();
		}
    }
    
    public void customizeOrder() {
    	System.out.println("Place your order choice(s) by entering the index of the menu displayed.");
    	System.out.println("Enter 0 to end your order");
    	Scanner scan = new Scanner(System.in);
    	int orderChoice = scan.nextInt();
    	while(orderChoice != 0) {
    		// check if order choice was within menu index by using size
    		// hard coded at the moment
    		if (orderChoice > 3 || orderChoice < 1) {
    			System.out.println("Invalid menu index was entered. Try again.");
    		}
    		else {
                if (cart == null)
                    cart = new Cart();
    			Item itemExample1 = new Item(1001, 
    										"Apple", 
    										10.99, 
    										"NTU", 
    										"Side", 
    										2, 
    										"some apple slices");
    			cart.addCartItem(itemExample1);
    			System.out.println("Valid input, order has been added to cart.");
    			cart.displayCartItems();
    			cart.getTotalPrice();
    		}
    		System.out.println("What would you like to add next ?");
        	orderChoice = scan.nextInt();
    	}
    	System.out.println("Ordering has ended. Please proceed to make payment.");
    	System.out.println();
    }

    public void makePayment() {
        if (cart != null) {
        	System.out.println("makePayment is running");
            cart.displayCartItems();
            cart.getTotalPrice();
            // pull from payment code repo
            System.out.println("Payment successful. Thank you for your order!");
        } else {
            System.out.println("No items in the cart. Please add items before making payment.");
        }
    }

    public void trackOrderStatus() {

    }
    
    public void collectFood() {
        // check customerID + orderStatus
        System.out.println("Your food is ready for collection. Enjoy your meal!");
    }

}
