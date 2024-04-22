package application.customerui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import branch.Branch;
import branch.OrderManagement;
import exception.InputOutOfRange;


/**
 * <li>Customer Interface is the entry point for Overall Customer Interface.</li>
 * <li>Creates new objects of related classes for "Branch selection", "Ordering page","Adding/Customizing order" and "Payment"</li>
 *
 * @author FDAB 2
 * @version 3.0
 * @since 2024-19-04
 *
 */
public class CustomerInterface {
	
	/**
	 * Constructor for Customer Interface
	 * @param sc Scanner object 
	 * @param branchList ArrayList containing different Branch objects
	 */
    public CustomerInterface(Scanner sc, ArrayList<Branch> branchList) {
        System.out.println("------------------");
        System.out.println("LOGIN AS CUSTOMER");
        System.out.println("------------------");
        
        while (true) {
            BranchSelectionPage branchSelectionPage = new BranchSelectionPage(sc, branchList);
            Branch currentBranch = branchSelectionPage.getCurrentBranch();
            if (currentBranch == null) {
                break;
            }
            System.out.println("WELCOME TO " + currentBranch.getBranchName() + "!");
            System.out.println("Please choose your option as a customer:");
            System.out.println("1. View existing Order");
            System.out.println("2. Make new Order");
            System.out.println("3. Go back");
            System.out.print("Enter your choice: ");
            int customerChoice = sc.nextInt();
            try {
                switch (customerChoice) {
                    case 1:
                        
                        break;
                    case 2:
                        OrderManagement orderManagement = new OrderManagement(currentBranch);

                        OrderingPage orderingPage = new OrderingPage(sc, currentBranch.getItemList());
                        if (!orderingPage.isCheckedOut()) {
                            currentBranch = null;
                            continue;
                        }

            PaymentPage paymentPage = new PaymentPage(sc, currentBranch.getOrderId(), orderingPage.getCart());
                        if (!paymentPage.isSuccessPayment()) {
                            continue;
                        }
                        orderManagement.addOrder(paymentPage.getOrder());
            System.out.println("Your Order ID is: " + paymentPage.getOrderId());
                        break;
                    default:
                        throw new InputOutOfRange();
                }
            } 
            catch (InputOutOfRange e) {
                System.out.println("Invalid input.");
            } 
            catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                sc.next();
            }

                
        }
    }
}
