package application.customerui;

import java.util.ArrayList;
import java.util.Scanner;

import branch.Branch;

public class CustomerInterface {
    public CustomerInterface(Scanner sc, ArrayList<Branch> branchList) {
        Branch currentBranch = null;
        int currentStage = 1;
        System.out.println("--------------------");
        System.out.println("LOGIN AS CUSTOMER");
        System.out.println("--------------------");
        
        while (true) {
            switch (currentStage) {
                case 1:
                    BranchSelectionPage branchSelectionPage = new BranchSelectionPage(sc, branchList);
                    currentBranch = branchSelectionPage.getCurrentBranch();
                    if (currentBranch == null) {
                        currentStage--;
                    }
                    else {
                        currentStage++;
                    }
                    break;
                case 2:
                    OrderingPage orderingPage = new OrderingPage(sc, currentBranch.getItemList());
                    if (orderingPage.isCheckedOut()) {
                        currentStage++;
                    }
                    else {
                        currentStage--;
                    }
                    break;
                case 3:
                    break;
                default:
                    return;
            }
        }
    }
}
