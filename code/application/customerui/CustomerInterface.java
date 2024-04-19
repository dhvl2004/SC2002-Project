package application.customerui;

import java.util.ArrayList;
import java.util.Scanner;

import branch.Branch;
import branch.OrderManagement;


/**
 * 
 * @author Lam Do
 * @version 1.1
 * @since 2024-19-04
 *
 */
public class CustomerInterface {
	
	/**
	 * Constructor for Customer Interface
	 * @param sc Scanner object 
	 * @param branchList ArrayList of Branch objects
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
