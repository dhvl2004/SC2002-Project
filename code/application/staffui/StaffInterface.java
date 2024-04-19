package application.staffui;

import java.util.Scanner;

import system.Database;

public class StaffInterface {
    enum StaffType {STAFF, MANAGER, ADMINISTRATOR};

    public StaffInterface(Scanner sc, Database database) {
        LoginPage loginPage = new LoginPage(sc, database.getAccountList());
        
        if (!loginPage.isSuccessLogin()) {
            System.out.println("Login failed. Please try again.");
            return;
        }
        
        switch (loginPage.getStaffType()) {
            case ADMINISTRATOR:
                AdminPage adminPage = new AdminPage(sc, database);
                // Additional logic for administrators
                break;
            case MANAGER:
                ManagerPage managerPage = new ManagerPage();
                // Additional logic for managers
                break;
            case STAFF:
                StaffPage staffPage = new StaffPage();
                // Additional logic for staff
                break;
            default:
                System.out.println("Invalid staff type.");
                break;
        }
        // Additional logic after page instantiation
    }
}
