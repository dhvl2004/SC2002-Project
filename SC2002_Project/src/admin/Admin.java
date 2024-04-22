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

public class Admin extends User {
    public Admin(String adminId, String password, String name, Gender gender, int age, String branchName) {
    	super(UserType.ADMINISTRATOR, adminId, password, name, gender, age, branchName);
    }
    
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
