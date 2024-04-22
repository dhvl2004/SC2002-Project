package application.staffui;

import java.util.Scanner;

import admin.Admin;
import staff.Manager;
import staff.Staff;
import system.BranchManagement;
import system.Database;

public class StaffInterface {

    public StaffInterface(Scanner sc, Database database) {
        LoginPage loginPage = new LoginPage(sc, database.getAccountList(), 3);
        
        if (!loginPage.isSuccessLogin()) {
            System.out.println("Login failed.");
            return;
        }
        System.out.println("Login successful.");

        BranchManagement branchManagement = new BranchManagement(database);
        switch (loginPage.user.getUserType()) {
            case ADMINISTRATOR:
                Admin admin = (Admin) loginPage.user;
                new AdminPage(sc, admin, database);
                break;
            case MANAGER:
                Manager manager = (Manager) loginPage.user;
                new ManagerPage(sc, manager, branchManagement.getBranch(manager.getBranch().getBranchName()));
                break;
            case STAFF:
                Staff staff = (Staff) loginPage.user;
                new StaffPage(sc, staff, branchManagement.getBranch(staff.getBranch().getBranchName()));
                break;
            default:
                System.out.println("Invalid staff type.");
                break;
        }
    }
    
    public static void showStaffInterface() {
    	
    }
}
