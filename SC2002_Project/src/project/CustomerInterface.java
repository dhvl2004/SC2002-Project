package project;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class CustomerInterface {
	
	public boolean running = true;
	public String branchLocation;
	public int diningOption;
	public int customerAction;
	
	public void customerInterface() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome Customer!");
		System.out.println("Please choose your current branch location: ");
		branchLocation = scan.next();
		
		System.out.println();
		System.out.println("Choose your Dining Option: ");
		System.out.println("Enter 1 for Dining In");
		System.out.println("Enter 2 for Takeaway");
		diningOption = scan.nextInt();
		
		final String directory = System.getProperty("user.dir");
		String filename = directory + "/resources/menu_list(1).csv";
		try {
			ItemDB.loadItems(filename);
			Item.printItemsBranch(branchLocation);
		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
		}
		System.out.println();
	
		
		while (running) {
			System.out.println("What would you like to do? ");
			System.out.println("1. To place order");
			System.out.println("2. To display item's description ");
			System.out.println("3. To check current order");
			System.out.println("0. To exit Customer Interface");
			
			customerAction = scan.nextInt();
			switch(customerAction) {
				case 1:
					System.out.println("Which Category would you like to order from ?");
					// Order order = new Order();
					break;
				case 2:
					System.out.println("Item description blah blah");
					//print out menu items and item descriptions only
					System.out.println();
					break;
				case 0:
					System.out.println("You have chose to exit the Customer Interface");
					running = false;
					break;
				default:
					System.out.println("Invalid response. Try again.");
					break;
			}			
		}
		
		return;

	}
		
}
