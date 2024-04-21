package application.customerui;

import java.util.ArrayList;
import java.util.Scanner;

import branch.Branch;
import branch.OrderManagement;


/**
 * <li>Customer Interface is the entry point for Overall Customer Interface.</li>
 * <li>Creates new objects of related classes for "Branch selection", "Ordering page","Adding/Customizing order" and "Payment"</li>
 *
 * @author FDAB 2
 * @version 2.0
 * @since 2024-19-04
 *
 */
public class CustomerInterface {
	
	/**
	 * Constructor for Customer Interface
	 * @param sc - Scanner object 
	 * @param branchList - ArrayList containing different Branch objects
	 */
    public CustomerInterface(Scanner sc, ArrayList<Branch> branchList) {
        System.out.println("--------------------");
        System.out.println("LOGIN AS CUSTOMER");
        System.out.println("--------------------");
        
        while (true) {
            BranchSelectionPage branchSelectionPage = new BranchSelectionPage(sc, branchList);
            Branch currentBranch = branchSelectionPage.getCurrentBranch();
            if (currentBranch == null) {
                break;
            }
            OrderManagement orderManagement = new OrderManagement(currentBranch);

            OrderingPage orderingPage = new OrderingPage(sc, currentBranch.getItemList());
            if (!orderingPage.isCheckedOut()) {
                currentBranch = null;
                continue;
            }

            PaymentPage paymentPage = new PaymentPage(sc, orderingPage.getCart());
            if (!paymentPage.isSuccessPayment()) {
                continue;
            }
            orderManagement.addOrder(paymentPage.getOrder());
            break;
        }
    }
}
