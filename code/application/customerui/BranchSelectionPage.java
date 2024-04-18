package application.customerui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import branch.Branch;

class BranchSelectionPage {
    private Branch currentBranch = null;
        BranchSelectionPage(Scanner sc, ArrayList<Branch> branchList) {
            while (this.currentBranch == null) {
                try {
                    System.out.println("Please choose your current branch:");
                    for (int i = 0; i < branchList.size(); i++) {
                        System.out.println((i + 1) + ". " + branchList.get(i).getBranchName());
                    }
                    System.out.println((branchList.size() + 1) + ". Go back");
                    System.out.println();
        
                    System.out.print("Enter the branch index: ");
                    int choice = sc.nextInt();
        
                    if (choice < 1 || choice > branchList.size() + 1) {
                        throw new InputMismatchException(); // change to a different exception for clarity with non integer input
                    }
                    if (choice == branchList.size() + 1) {
                        return;
                    }
        
                    currentBranch = branchList.get(choice - 1);
                    System.out.println("You are currently in " + currentBranch.getBranchName());
                    System.out.println();
                } 
                catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid branch index.");
                    System.out.println();
                    sc.next();
                }
            }
        }
    
    public Branch getCurrentBranch() {
        return currentBranch;
    }
}
