package application.customerui;

import java.util.ArrayList;

import branch.Branch;

public class CustomerInterface {
    private ArrayList<Branch> branchList;

    public CustomerInterface(ArrayList<Branch> branchList) {
        this.branchList = branchList;
        WelcomePage welcomePage = new WelcomePage(branchList);
        while (true) {

        }
        
    }
}
