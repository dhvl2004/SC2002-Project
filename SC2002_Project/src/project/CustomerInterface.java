package project;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class CustomerInterface {
	
	public String branchLocation;
	public int diningOption;
	
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
		System.out.println();
		
		boolean running = true;
		while (running) {
			System.out.println("What would you like to do? ");
			System.out.println("1. Browse menu");
			System.out.println("2. Customize order");
			System.out.println("3. Make payment");
			System.out.println("4. Track order status");
			System.out.println("5. Collect food ");
			System.out.println("0. Exit Customer Interface");
			
			Customer customer = new Customer();
			int customerAction;			
			customerAction = scan.nextInt();
			switch(customerAction) {
				case 1:
					customer.browseMenu(branchLocation);
					break;
					
				case 2:
					customer.customizeOrder();;
					break;
					
				case 3:
					customer.makePayment();
					//print out menu items and item descriptions only
					System.out.println();
					break;
					
				case 4:
					System.out.println("Item description blah blah");
					//print out menu items and item descriptions only
					System.out.println();
					break;
					
				case 0:
					System.out.println("You have chose to exit the Customer Interface");
					running = false;
					break;
					
				default:
					System.out.println("Invalid customer response. Try again.");
					break;
			}			
		}
		
		return;

	}
		
}
