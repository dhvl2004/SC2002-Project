package application.staffui;

import java.util.Scanner;

import admin.Admin;
import staff.Manager;
import staff.Staff;
import system.BranchManagement;
import system.Database;

/**
 * <li>General UI for staff after they login
 * <li> The class will direct staff to their respective login pages based on what type of staff they are.
 * @author FDAB 2
 * @version 1.0 
 * 
 */
public class StaffInterface {

	
	/**
	 * Constructor for StaffInterface class
	 * @param sc Scanner object
	 * @param database Database used to retrieve and write to all staff account
	 */
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
