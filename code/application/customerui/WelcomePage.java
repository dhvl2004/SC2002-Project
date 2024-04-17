package application.customerui;

import java.util.ArrayList;
import java.util.Scanner;

import application.Page;
import branch.Branch;

class WelcomePage implements Page {
    WelcomePage(ArrayList<Branch> branchList) {
        System.out.println("LOGIN AS CUSTOMER");
        Scanner sc = new Scanner(System.in);

        System.out.println("Please choose your current branch:");
        for (int i = 0; i < branchList.size(); i++) {
            System.out.println((i + 1) + ". " + branchList.get(i).getBranchName());
        }
        System.out.println();
        
        System.out.print("Please enter the branch index: ");
        int choice = sc.nextInt();
        // add exception for not integer, not positive, exceed max index
        Branch branch = branchList.get(choice - 1);
        System.out.println("You are currently in " + branch.getBranchName());
        sc.close();
    }
    
    public void exit() {
        
    }
}
