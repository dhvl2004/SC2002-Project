package application.staffui;

import java.util.ArrayList;
import java.util.Scanner;

import system.AccountManagement;
import system.User;

class LoginPage {
    private boolean successLogin = false;
    User user = null;
    LoginPage(Scanner sc, ArrayList<User> accountList, int passwordTrial) {
        AccountManagement accountManagement = new AccountManagement(accountList);

        String userId = null;
        while (this.user == null) {
            System.out.print("Enter ID: ");
            userId = sc.next();
            this.user = accountManagement.getUser(userId);
            if (this.user == null) {
                System.out.println("Unknown User! Please enter a different ID.");
                return;
            }
        }

        String password;
        int userTrial = 0;
        while (userTrial < passwordTrial) {
            System.out.print("Enter Password: ");
            password = sc.next();
            if (password.equals(user.getPassword())) {
                successLogin = true;
                break;
            }
            userTrial++;
            System.out.println("Incorrect password. " + (passwordTrial - userTrial) + " tires left.");
        }
        if (userTrial == passwordTrial) {
            this.user = null;
            System.out.println("Login Failed! Too many incorrect attempts.");
        }
    }

    public boolean isSuccessLogin() {
        return successLogin;
    }
}
