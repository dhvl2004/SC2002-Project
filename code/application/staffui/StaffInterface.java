package application.staffui;

import system.Database;

public class StaffInterface {
    enum StaffType {STAFF, MANAGER, ADMIN};

    private Database database;

    public StaffInterface(Database database) {
        this.database = database;
        LoginPage loginPage = new LoginPage(this.database.getAccountList());
        if (!loginPage.isSuccessLogin()) {
            System.exit(0);
        }
        switch (loginPage.getStaffType()) {
            case ADMIN:
                AdminPage adminPage = new AdminPage(this.database);
                break;
            case MANAGER:
                ManagerPage managerPage = new ManagerPage();
                break;
            case STAFF:
                StaffPage staffPage = new StaffPage();
                break;
            default:
                break;
        }

    }
}
