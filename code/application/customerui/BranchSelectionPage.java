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
                    System.out.println((branchList.size() + 1) + ". Return to Start");     
                    System.out.print("Enter your choice: ");

                    int branchChoice = sc.nextInt();
        
                    if (branchChoice < 1 || branchChoice > branchList.size() + 1) {
                        throw new InputMismatchException();
                    }
                    if (branchChoice == branchList.size() + 1) {
                        return;
                    }
        
                    currentBranch = branchList.get(branchChoice - 1);
                    System.out.println();
                    System.out.println("You are currently in " + currentBranch.getBranchName() + "!");
                    System.out.println();
                } 
                catch (InputMismatchException e) {
                    System.out.println("Invalid input.");
                    System.out.println();
                    sc.next();
                }
            }
        }
    
    public Branch getCurrentBranch() {
        return currentBranch;
    }
}
