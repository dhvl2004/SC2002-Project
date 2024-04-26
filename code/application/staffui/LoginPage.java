package application.staffui;

import java.util.ArrayList;
import java.util.Scanner;

import system.AccountManagement;
import system.User;


/**
 *<li>Class is of boundary stereotype and represents the UI for any staff member to login with a valid password
 *<li>Class will reject Login attempt after 3 tries
 *@author FDAB 2
 *@version 1.0 
 *
 *
 */
class LoginPage {
    private boolean successLogin = false;
    User user = null;
    
    /**
     * Constructor for LoginPage Class, upon instantiation Login UI is created 
     * @param sc Scanner object
     * @param accountList List of all staff accounts
     * @param passwordTrial Number of allowable password attempts
     */
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
            System.out.println("Incorrect password. " + (passwordTrial - userTrial) + " trial(s) left.");
        }
        if (userTrial == passwordTrial) {
            this.user = null;
            System.out.println("Login Failed! Too many incorrect attempts.");
        }
    }

    
    /**
     * Method identifies if the login on the Login Page has been successful or not
     * @return successLogin Attribute, which is a boolean representing True if login is a success
     */
    public boolean isSuccessLogin() {
        return successLogin;
    }
}
