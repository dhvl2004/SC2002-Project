package application.customerui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import branch.Branch;


/**
 * 
 * <li>Class that Allows users to choose their preferred branch and brings them to the options provided by said Branch</li>
 * @author FDAB 2
 * @version 2.0
 * @since 2024
 * 
 */
class BranchSelectionPage {
    private Branch currentBranch = null;
    
	    /**
	     * Public constructor for "BranchSelectionPage", it takes in user's preferred branch and brings them to UI of that branch
	     * @param sc Scanner Object
	     * @param branchList ArrayList of Existing Branches
	     */
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
    /**
     * Get method for retrieving the "currentBranch" attribute of "branchSelectionPage"
     * @return  Returns the current branch that the class is displaying to user
     */

    public Branch getCurrentBranch() {
        return currentBranch;
    }
}
