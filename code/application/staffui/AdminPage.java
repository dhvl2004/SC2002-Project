package application.staffui;

import java.util.Scanner;

import admin.Admin;
import system.Database;

/**
 * <li>UI interface for Administrator
 * <li>Provide options to execute actions that Administrator can carry out by calling functions of Administrator class
 * @author FDAB 2
 * @version 1.0 
 * 
 */
class AdminPage {
//	private Database database;
//	private Admin admin;
	
	/**
	 * Constructor for AdminPage 
	 * @param sc Scanner object
	 * @param admin Admin that is login in
	 * @param database DataBase that admin will interact with
	 */
    AdminPage(Scanner sc, Admin admin, Database database) {
//    	this.database = database;
//    	this.admin = admin;
    	while (true) {
        	System.out.println("\n--------------------");
            System.out.println("LOGIN AS ADMIN");
            System.out.println("--------------------");

            System.out.println("Choose your action:");
            System.out.println("1. Display Staff List");
            System.out.println("2. Add, Edit or Remove Staff Accounts");
//            System.out.println("3. Assign Manager");
            System.out.println("3. Promote Staff");
            System.out.println("4. Transfer Staff/Manager");
            System.out.println("5. Add/Remove Payment Method");
            System.out.println("6. Open/Close Branch");
            System.out.println("7. Add/Remove Branch");
            System.out.println("8. Change Password");
            System.out.println("9. Return to Start");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
            	case 1:
            		admin.displayStaffAccounts(database.getAccountList());
            		admin.chooseFilter(sc, database.getAccountList(), database);
            		break;
                case 2:
                	admin.manageAccounts(sc, database.getAccountList(), database);
                	break;
                case 3:
                	admin.promoteStaff(sc, database.getAccountList(), database);
                	break;
                case 4:
            		admin.displayStaffAccounts(database.getAccountList());
                	admin.transferStaff(sc, database.getAccountList(), database);
                	break;
                case 5:
                	admin.addRemovePayment(sc);
                	break;
                case 6:
                	admin.openCloseBranch(sc, database);
                	break;
                case 7:
                	admin.addRemoveBranch(sc, database);
                	break;
                case 8:
                	admin.changePassword(sc);
                	break;
                case 9:
                    System.out.println("...Returning to Start...");
                    return;
                default:
                    break;
            }
//            return;
        }
    }
}
