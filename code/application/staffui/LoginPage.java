package application.staffui;

import java.util.ArrayList;
import java.util.Scanner;

import application.staffui.StaffInterface.StaffType;
import staff.Manager;
import system.AccountManagement;
import system.Admin;
import system.User;

class LoginPage {
    private boolean successLogin = false;
    private User currentUser;
    private StaffType staffType;
    private int passwordTrial = 3;

    LoginPage(ArrayList<User> accountList) {
        AccountManagement accountManagement = new AccountManagement(accountList);
        Scanner sc = new Scanner(System.in);

        String userId = null;
        do {
            if (userId != null) {
                System.out.println("Unknown User! Please enter a different ID.");
            }
            System.out.print("Enter ID: ");
            userId = sc.next();
            this.currentUser = accountManagement.find(userId);
        } while (currentUser == null);

        if (this.currentUser instanceof Admin) {
            this.staffType = StaffType.ADMIN;
        }
        else if (currentUser instanceof Manager) {
            this.staffType = StaffType.MANAGER;
        }
        else {
            this.staffType = StaffType.STAFF;
        }

        String password;
        int userTrial = 0;
        while (userTrial < passwordTrial) {
            System.out.print("Enter Password: ");
            password = sc.next();
            if (password == this.currentUser.getPassword()) {
                this.successLogin = true;
                break;
            }
            userTrial++;
        }
        if (userTrial == passwordTrial) {
            System.out.println("Login Failed!");
        }
        sc.close();
    }

    StaffType getStaffType() {
        return this.staffType;
    }

    boolean isSuccessLogin() {
        return successLogin;
    }
}
