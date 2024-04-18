package application.staffui;

import system.Database;

public class StaffInterface {
    enum StaffType {STAFF, MANAGER, ADMINISTRATOR};

    private Database database;

    public StaffInterface(Database database) {
        this.database = database;
        LoginPage loginPage = new LoginPage(this.database.getAccountList());
        
        if (!loginPage.isSuccessLogin()) {
            System.out.println("Login failed. Please try again.");
            return;
        }
        
        switch (loginPage.getStaffType()) {
            case ADMINISTRATOR:
                AdminPage adminPage = new AdminPage(this.database);
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
