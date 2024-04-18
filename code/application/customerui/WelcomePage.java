package application.customerui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import branch.Branch;

class WelcomePage {
    private Branch chosenBranch;

    WelcomePage(ArrayList<Branch> branchList) {
        System.out.println("LOGIN AS CUSTOMER");
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Please choose your current branch:");
            for (int i = 0; i < branchList.size(); i++) {
                System.out.println((i + 1) + ". " + branchList.get(i).getBranchName());
            }
            System.out.println();

            System.out.print("Please enter the branch index: ");
            int choice = sc.nextInt();

            if (choice < 1 || choice > branchList.size()) {
                throw new InputMismatchException("Invalid branch index.");
            }

            this.chosenBranch = branchList.get(choice - 1);
            System.out.println("You are currently in " + this.chosenBranch.getBranchName());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid branch index.");
        } finally {
            sc.close();
        }
    }

    public Branch getChosenBranch() {
        return chosenBranch;
    }
}
