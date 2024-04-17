package application.staffui;

import system.Database;

public class StaffInterface {
    enum StaffType {STAFF, MANAGER, ADMIN};

    private Database database;
    private StaffType staffType;

    public StaffInterface(Database database) {
        this.database = database;
        LoginPage loginPage = new LoginPage(this.database.getAccountList());
        if (!loginPage.isSuccessLogin()) {
            
        }
        this.staffType = loginPage.getStaffType();
        switch (staffType) {
            case ADMIN:
                AdminPage adminPage = new AdminPage(database);
                break;
            case MANAGER:

                break;
            case STAFF:

                break;
            default:
                break;
        }

    }
}
