package project;

import java.util.Scanner;
import java.io.IOException;

public class Customer {
	private int customerID;	//for collectFood (may not need)
	
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
    	Scanner scan = new Scanner(System.in);
    	int orderChoice = scan.nextInt();
    	while(orderChoice != 0) {
    		
    	}
    }

    public void trackOrderStatus() {

    }

    public void makePayment() {
        // pull from payment code repo
        System.out.println("Payment successful. Thank you for your order!");
    }

    public void collectFood() {
        // check customerID + orderStatus
        System.out.println("Your food is ready for collection. Enjoy your meal!");
    }

}
