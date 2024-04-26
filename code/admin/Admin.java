package admin;

import java.util.ArrayList;
import java.util.Scanner;

import branch.Branch;
import branch.Branch.OperationStatus;
import branch.ManagerManagement;
import branch.StaffManagement;
import filter.Filter;
import staff.Manager;
import staff.Staff;
import system.AccountManagement;
import system.BranchManagement;
import system.Database;
import system.User;
import payment.PaymentMode;
import payment.CardPaymentMode;
import payment.OnlinePaymentMode;

/**
 * <li>Administrator class that extends from User Class
 * <li>A specialization of a type of user
 * <li>Administrator class is given highest access and methods to fully edit and change the states and attributes of Staff,customer order and branch under the Administrator
 * <li>Administrator also has unique functionalities like transfering, promoting managers and removing a payment option for a branch
 * @author FDAB 2
 * @version 2.0 
 */
public class Admin extends User {
	
	/**
	 * Constructor for Admin class
	 * @param adminId ID identifying the administrator
	 * @param password Password of Administrator
	 * @param name Name of Administrator
	 * @param gender Gender of Administrator
	 * @param age age of Administrator
	 * @param branchName Name of Branch that Administrator is employed in 
	 */
    public Admin(String adminId, String password, String name, Gender gender, int age, String branchName) {
    	super(UserType.ADMINISTRATOR, adminId, password, name, gender, age, branchName);
    }
    
    
    /**
     * Method that prints out all staff and managers under the Administrator along with their information like age,gender,etc.
     * @param accounts List of all user accounts managed by Administrator
     * @return <li>False if no accounts are found 
     * <li>True if at least one staff exist and information is printed
     */
    public boolean displayStaffAccounts(ArrayList<User> accounts) {
    	if (accounts.isEmpty()) {
    		System.out.println("No accounts found");
    		return false;
    	}
    	for (User user : accounts) {
    		System.out.println("Name: " + user.getName() + 
    				", Login Id: " + user.getUserId() +
//    				", Password: " + user.getPassword() +
    				", Role: " + user.getUserType() +
    				", Branch: " + user.getBranchName() +
    				", Gender: " + user.getGender() + 
    				", Age: " + user.getAge());
    	}
    	return true;
    }
    
    
    /**
     * <li>Method for Administrator to be able to view all staff by specific filters
     * @param sc Scanner object
     * @param accounts all accounts under Administrator
     * @param database Database where information of these accounts are being read and retrieve from
     */
    public void chooseFilter(Scanner sc, ArrayList<User> accounts, Database database) {
    	ArrayList<User> filteredList = new ArrayList<User>();
    	Filter filter = new Filter(sc, accounts, database);
    	while (true) {
    		System.out.println("Choose filter:");
        	System.out.println("1. Role");
        	System.out.println("2. Branch");
        	System.out.println("3. Gender");
        	System.out.println("4. Age");
        	System.out.println("5. Go Back");
        	
        	if (sc.hasNextLine()) sc.nextLine();
        	int choice = sc.nextInt();
        	switch (choice) {
        		case 1:
        	    	filteredList = filter.roleFilter(); 
        	    	displayStaffAccounts(filteredList);
        	    	break;
        		case 2:
        			filteredList = filter.branchFilter();
        			displayStaffAccounts(filteredList);
        			break;
        		case 3:
        			filteredList = filter.genderFilter();
        			displayStaffAccounts(filteredList);
        			break;
        		case 4:
        			filteredList = filter.ageFilter();
        			displayStaffAccounts(filteredList);
        			break;
        		case 5:
    			default:
    				return;
        	}
    	}
    }
    
    
    /**
     * Method is an UI for the facilitation of adding,editing and removing Accounts under the Administrator
     * @param sc Scanner object
     * @param accounts all accounts under the Administrator
     * @param database Database where information of these accounts are being read and retrieve from
     */
    public void manageAccounts(Scanner sc, ArrayList<User> accounts, Database database) {
    	AccountManagement accountManager = new AccountManagement(sc, accounts, database);
    	while (true) {
    		System.out.println("Choose your action:");
        	System.out.println("1. Add");
        	System.out.println("2. Edit");
        	System.out.println("3. Remove");
        	System.out.println("4. Go Back");
//        	if (sc.hasNextLine()) sc.nextLine();
        	int choice = sc.nextInt();
        	switch (choice) {
        		case 1:
        			accountManager.addAccount();
        			break;
        		case 2:
        			displayStaffAccounts(accounts);
        			accountManager.editAccount();
        			break;
        		case 3:
        	    	displayStaffAccounts(accounts);
        	    	accountManager.removeAccount();
        			break;
        		case 4:
    			default:
    				return;
        	}
    	}
    }
    
    
    /**
     * <li>Method allows Administrator to promote a staff into a manager for a branch
     * <li>Method will convert the type of the staff object into a manager object , while keeping the same object under the same branch
     * <li>The method will reject operation if the quota of the branch is at limit capacity or if the staff is already promoted to manager
     * @param sc scanner object
     * @param accounts all accounts under the Administrator
     * @param database Database where information of these accounts are being read and retrieve from
     */
    public void promoteStaff(Scanner sc, ArrayList<User> accounts, Database database) {
    	ArrayList<User> staffList = new ArrayList<User>();
    	for (User user : accounts) {
    		if (user.getUserType() == UserType.STAFF) staffList.add(user);
    	}
    	displayStaffAccounts(staffList);
    	System.out.print("Enter Login Id of Staff to promote: ");
    	if (sc.hasNextLine()) sc.nextLine();
    	String loginId = sc.nextLine();
    	AccountManagement accountManager = new AccountManagement(accounts);
    	Staff user = (Staff)accountManager.getUser(loginId);
    	if (user == null) {
        	System.out.println("No staff found with Login Id: " + loginId);
        	return;
    	}
    	Branch branch = user.getBranch();
    	Manager manager = new Manager(branch, user.getUserId(), user.getPassword(), user.getName(), user.getGender(), user.getAge());
    	ManagerManagement mm = new ManagerManagement(branch);
    	if (mm.addManager(manager) == false) {
			System.out.println("Unable to promote staff: Manager already exist in branch or Manager quota exceeded");
			return;
    	}
    	accountManager.removeUser(loginId);
    	accountManager.addUser(manager);
//    	user.setUserType(UserType.MANAGER);
    	StaffManagement sm = new StaffManagement(manager.getBranch());
    	sm.removeStaff(loginId);
		System.out.println(manager.getName() + " promoted to Manager");
    }
    
    
    /**
     * <li>Method allows Administrator to be able to transfer staff to another branch
     * <li>The method will reject the transfer if target branch is already at max capacity
     * @param sc Scanner object
     * @param accounts all accounts under the Administrator
     * @param database Database where information of these accounts are being read and retrieve from
     */
    public void transferStaff(Scanner sc, ArrayList<User> accounts, Database database) {
    	System.out.print("Enter Login Id of Staff/Manager to transfer: ");
    	if (sc.hasNextLine()) sc.nextLine();
    	String loginId = sc.nextLine();
    	AccountManagement accountManager = new AccountManagement(accounts);
    	User user = accountManager.getUser(loginId);
    	if (user == null) {
        	System.out.println("No staff found with Login Id: " + loginId);
        	return;
    	}
    	System.out.println("Select branch to transfer to:");
    	int i = 1;
    	ArrayList<Branch> branchList = new ArrayList<>(database.getBranchList());    	
    	branchList.remove(((Staff)user).getBranch());
    	for (Branch branch : branchList) {
    		System.out.println(i++ + ". " + branch.getBranchName());
    	}
    	System.out.println(i + ". Go Back");
    	int choice = sc.nextInt();
    	if (choice > branchList.size() || choice < 1) return;
    	Branch branch = branchList.get(choice-1);
    	if (user.getUserType() == UserType.STAFF) {
    		StaffManagement sm = new StaffManagement(branch);
    		Staff staff = (Staff)user;
    		if (sm.addStaff(staff) == false) {
    			System.out.println("Unable to transfer staff: Staff already exist in branch or Staff quota exceeded");
				return;
    		}
    		sm = new StaffManagement(staff.getBranch());
    		sm.removeStaff(loginId);
    		staff.setBranch(branch);
			System.out.println("Staff transferred to " + branch.getBranchName());
    	} else if (user.getUserType() == UserType.MANAGER) {
        	ManagerManagement mm = new ManagerManagement(branch);
        	Manager manager = (Manager)user;
        	if (mm.addManager(manager) == false) {
        		System.out.println("Unable to transfer manager: Manager already exist in branch or Manager quota exceeded");
				return;
        	}
        	mm = new ManagerManagement(manager.getBranch());
        	mm.removeManager(loginId);
        	manager.setBranch(branch);
			System.out.println("Manager transferred to " + branch.getBranchName());
    	}
    }
    
    
    /**
     * <li>The method gives administrator the ability to remove and/or add a new or existing payment option
     * <li>This method effectively affects the payment class's availability itself, meaning if one payment type is added/removed, all branches will gain/lose this payment type 
     * @param sc Scanner object
     */
    public void addRemovePayment(Scanner sc) {
    	System.out.println("Select Payment Mode:");
    	System.out.println("1. Online Payment");
    	System.out.println("2. Card Payment");
    	System.out.println("3. Go Back");
    	int choice = sc.nextInt();
//    	if (choice > 2 || choice < 1) return;
    	boolean availablility;
    	int c;
    	switch (choice) {
    		case 1:
    			OnlinePaymentMode pm = new OnlinePaymentMode();
    			availablility = pm.isAvailable();
				System.out.println((availablility ? "Remove" : "Add") + " Online Payment?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				c = sc.nextInt();
				if (c != 1) return;
				pm.setAvailability(!availablility);
				System.out.println("Online Payment " + (availablility ? "Removed" : "Added"));
				break;
    		case 2:
    			CardPaymentMode cm = new CardPaymentMode();
    			availablility = cm.isAvailable();
				System.out.println((availablility ? "Remove" : "Add") + " Card Payment?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				c = sc.nextInt();
				if (c != 1) return;
				cm.setAvailability(!availablility);
				System.out.println("Card Payment " + (availablility ? "Removed" : "Added"));
				break;
    		case 3:
			default:
				break;
    	}
    }
    
    
    /**
     * <li>Method allows administrator to be able to open a new branch or close an existing branch
     * <li>By closing a branch, it means that the operation status of the branch is switched from open to close. Staff ,food item and other information are still retained.
     * @param sc Scanner object
     * @param database Database where information of these accounts are being read and retrieve from
     */
    public void openCloseBranch(Scanner sc, Database database) {
    	System.out.println("Select branch:");
    	int i = 1;
    	ArrayList<Branch> branchList = database.getBranchList();
    	for (Branch branch : branchList) {
    		System.out.println(i++ + ". " + branch.getBranchName());
    	}
    	System.out.println(i + ". Go Back");
    	int choice = sc.nextInt();
    	if (choice > branchList.size() || choice < 1) return;
    	Branch branch = branchList.get(choice-1);
		if (branch.getOperationStatus() == OperationStatus.CLOSE) {
			System.out.println("Branch: " + branch.getBranchName() + " is CLOSED.");
			System.out.println("1. Open Branch");
			System.out.println("2. Go Back");
			if (sc.hasNextLine()) sc.nextLine();
			if (sc.nextInt() != 1) return;
			branch.setOperationStatus(OperationStatus.OPEN);
			System.out.println("Branch: " + branch.getBranchName() + " is now OPEN.");
		} else if (branch.getOperationStatus() == OperationStatus.OPEN) {
			System.out.println("Branch: " + branch.getBranchName() + " is OPEN.");
			System.out.println("1. Close Branch");
			System.out.println("2. Go Back");
			if (sc.hasNextLine()) sc.nextLine();
			if (sc.nextInt() != 1) return;
			branch.setOperationStatus(OperationStatus.CLOSE);
			System.out.println("Branch: " + branch.getBranchName() + " is now CLOSED.");
		}
    }
    
    /**
     * <li>This method allows administrator to add or remove a branch
     * <li>This is different from opening and removing a branch
     * <li>Removing a branch will purge all data and information related to that branch from CSV Database
     *  
     * @param sc Scanner Object
     * @param database Database where information of these accounts are being read and retrieve from
     */
    public void addRemoveBranch(Scanner sc, Database database) {
		BranchManagement bm = new BranchManagement(database);
		while (true) {
			System.out.println("Choose your action:");
	    	System.out.println("1. Add");
	    	System.out.println("2. Remove");
	    	System.out.println("3. Go Back");
	    	int choice = sc.nextInt();
	    	switch (choice) {
	    		case 1:
	    			Branch branch = new Branch("Pioneer", "Pioneer Mall", 5);
	    			if (bm.addBranch(branch) == false) {
	    				System.out.println("Branch already exist");
	    				break;
	    			}
	    			System.out.println("New branch added");
	    			break;
	    		case 2:
	    			System.out.println("Select branch to remove:");
	    	    	int i = 1;
	    	    	ArrayList<Branch> branchList = database.getBranchList();
	    	    	for (Branch b : branchList) {
	    	    		System.out.println(i++ + ". " + b.getBranchName());
	    	    	}
	    	    	System.out.println(i + ". Go Back");
	    	    	int c = sc.nextInt();
	    	    	if (c < 1 || c >= i) break;
	    	    	Branch b = branchList.get(c-1);
	    	    	System.out.println("Removing " + b.getBranchName() + " branch will also remove all items and accounts associated with it.");
	    	    	System.out.println("Confirm?");
	    	    	System.out.println("1. Yes");
	    	    	System.out.println("2. No");
	    	    	c = sc.nextInt();
	    	    	if (c != 1) break;
	    	    	bm.removeBranch(b.getBranchName());
	    	    	ArrayList<User> accountList = new ArrayList<User>(database.getAccountList());
	    	    	AccountManagement am = new AccountManagement(database.getAccountList());
	    	    	for (User user : accountList) {
	    	    		if (user.getBranchName().equals(b.getBranchName()))
	    	    			am.removeUser(user.getUserId());
	    	    	}
	    	    	System.out.println("Branch removed");
	    	    	break;
	    		case 3:
				default:
					return;
	    	}	
		}
    }
    
    /**
     * Methods sets up the changing of password for security measures, will validate and stop program if number of trials exit 3 attempts
     * @param sc scanner object
     */
    public void changePassword(Scanner sc) {
    	System.out.println("---Change Password---");
    	System.out.println("Enter Old Password: ");
    	String oldPassword = sc.next();
    	if (!oldPassword.equals(this.getPassword())) {
    		System.out.println("Incorrect Old Password");
    		return;
    	}
    	System.out.println("Enter New Password: ");
    	String newPassword1 = sc.next();
    	System.out.println("Confirm New Password: ");
    	String newPassword2 = sc.next();
    	if (newPassword1.equals(newPassword2)) {
    		this.setPassword(newPassword2);
    		System.out.println("Password has been changed");
    	}
    	else System.out.println("New passwords does not match");
    }
}
