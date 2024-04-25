package system;

import java.util.ArrayList;
import java.util.Scanner;

import admin.Admin;
import branch.Branch;
import branch.ManagerManagement;
import branch.StaffManagement;
import staff.Manager;
import staff.Staff;
import system.User.Gender;
import system.User.UserType;


/**
 * <li>Class that facilitates full access privileges to all accounts/users in any branch
 * <li> Class allows for adding,editing and removal of any account(Staff,Manager and Admin)
 * <li> Class directly interacts with CSV Database when removing , editing or Adding new Account information 
 *  @author FDAB 2
 * @version 1.0
 * <li>The class have 3 attributes...</li>
 * 
 * <ul>
	 * 	<li>accountlist - ArrayList containing all accounts in the Database
	 * 	<li> Scanner object
	 * 	<li> Database - The Database class that reads and Writes to the CSV DataBase file
 * </ul>
 * 
 */
public class AccountManagement {
	
	/**
	 * <li>ArrayList of all User objects
	 * <li> This attribute represents the arrayList of User accounts that will be manipulated
	 */
    private ArrayList<User> accountList;
    
    /**
     * Scanner object
     */
    private Scanner sc;
    
    /**
     * <li>The DataBase that represents information stored on the CSV DataBase
	 * <li> The DataBase will be read from and written to 
     */
    private Database database;
    
    /**
     * Base Constructor that creates the AccountManagement class
     * <li> Helps initialize object attribute accountList so as to allow adding,removing and editing of input users in accountList
     * @param accountList ArrayList of all user
     */

    public AccountManagement(ArrayList<User> accountList) {
        this.accountList = accountList;
    }
    
    /**
     * 
     * Constructor for AccountManagement, object created will have full access to edit accounts on the CSV Database
     * @param sc Scanner object
     * @param accounts arraylist of all accounts 
     * @param database DataBase to read and write to CSV Database
     */
    public AccountManagement(Scanner sc, ArrayList<User> accounts, Database database) {
    	this.accountList = accounts;
    	this.sc = sc;
    	this.database = database;
    }

    
    /**
     * <li>Method looks through all accounts and returns the user object of the specified userID
     * <li>Returns null if no matching account(user object) it found
     * @param userId Specific userID to retrieve
     * @return Account class of the userID
     */
    public User getUser(String userId) {
        for (User account : accountList) {
            if (userId.equals(account.getUserId())) {
                return account;
            }
        }
        return null;
    }

    
    /**
     * Method that adds a user into account list. If the userID already exists within account list, method returns False
     * @param user Takes in specified user object to be added
     * @return <li>Returns boolean True if adding user was successful
     *         <li> Returns false if user already exists, hence adding specified user is unsuccessful
     */
    public boolean addUser(User user) {
        if (this.getUser(user.getUserId()) != null) {
            return false;
        }

        this.accountList.add(user);
        return true;
    }

    
    /**
     * <li>Method removes user from current DataBase
     * <li> This method will not allow removal of admin accounts
     * @param userId UserId represents the User Account to be removed from DataBase
     * @return <li>If removal of User Object was successful.Returns User Object that has been successfully removed
     * 	       <li>Returns NULL if User object to be removed does not exist within DataBase or if User to be removed is an Administrator
     */
    public User removeUser(String userId) {
        User user = this.getUser(userId);
        if (user == null || user instanceof Admin) {
            return null;
        }

        this.accountList.remove(user);
        return user;
    }

    
    /**
     * <li>Method Facilitates the adding of new User into the DataBase
     * <li> The method asks for all required information of the User account to be added
     * <li>Method will throw exception and not allow adding of User account if one of the following is true...
     * <ul>
     * 		<li>Format of information for the User Account is incorrect
     * 		<li>Error occurs whilst writing to the CSV DataBase File
     * 		<li>If account to be added is Staff/Manager type and staff or Manager quota for that Branch is at limit
     * 		<li>If the Account to be added is Staff/Manager but the Branch does not exist
     * 		<li>If account to be added is Administrator but Admin account already exists
     * 			
     * 		
     * </ul> 
     */
    public void addAccount() {
    	System.out.println("Enter the following format:\nName,Login Id,Password,Role,Gender,Age,Branch");
    	if (sc.hasNextLine()) sc.nextLine();
    	String accountString = sc.nextLine();
    	String[] accountParts = accountString.split(",");
    	if (accountParts.length != 7) {
    		System.out.println("Error adding new account: Invalid format");
    		return;
    	}
    	try {
    		String name = accountParts[0].trim();
    		String loginId = accountParts[1].trim();
    		String password = accountParts[2].trim();
    		UserType role = UserType.valueOf(accountParts[3].trim().toUpperCase());
    		Gender gender = Gender.valueOf(accountParts[4].trim().toUpperCase());
    		int age = Integer.parseInt(accountParts[5].trim());
    		String branch = accountParts[6].trim();
    		BranchManagement bm = new BranchManagement(database);
    		Branch b = bm.getBranch(branch);
    		if (role == UserType.STAFF) {
				Staff user = new Staff(b, loginId, password, name, gender, age);
				StaffManagement staffManager = new StaffManagement(b);
				if (staffManager.addStaff(user) == false) {
    				System.out.println("Unable to add staff: Staff already exist in branch or Staff quota exceeded");
    				return;
				}
				addUser(user);
				System.out.println("Staff account added.");
				return;
			} else if (role == UserType.MANAGER) {
				Manager user = new Manager(b, loginId, password, name, gender, age);
				ManagerManagement managerManagement = new ManagerManagement(b);
				if (managerManagement.addManager(user) == false) {
    				System.out.println("Unable to add manager: Manager already exist in branch or Manager quota exceeded");
    				return;
				}
				addUser(user);
				System.out.println("Manager account added");
				return;
			} else if (role == UserType.ADMINISTRATOR) {
				System.out.println("Admin account already exist");
			}
    		System.out.println(branch + " not branch found. Add new branch first before adding account.");
    	} catch (Exception e) {
    		System.err.println("Error creating account: " + e.getMessage());
    	}
    }

    
    /**
     * <li>Method represents the general UI that facilitates editing attributes of a User Account object
     * <li> Gives the options to edit Name,LoginID,Gender,Age,etc of the User Account
     */
    public void editAccount() {
//    	displayStaffAccounts(accounts);
    	System.out.print("Enter Login Id of account to edit: ");
    	if (sc.hasNextLine()) sc.nextLine();
    	String loginId = sc.nextLine();
    	for (User user : accountList) {
    		if (loginId.equals(user.getUserId())) {
    			System.out.println("Choose what to edit:");
    			System.out.println("1. Name");
    			System.out.println("2. Login Id");
//    			System.out.println("3. Password");
//    			System.out.println("4. Role");
    			System.out.println("3. Gender");
    			System.out.println("4. Age");
//    			System.out.println("7. Branch");
    			System.out.println("5. Go Back");
    			int choice = sc.nextInt();
    			
    			switch (choice) {
    				case 1:
    					editName(sc, user);
    					return;
    				case 2:
    					editLoginId(sc, user);
    					return;
//    				case 3:
//    					editPassword(sc, user);
//    					return;
//    				case 4:
//    					editRole(sc, user);
//    					return;
    				case 3:
    					editGender(sc, user);
    					return;
    				case 4:
    					editAge(sc, user);
    					return;
    				case 5:
    				default:
    					return;
    			}
    		}
    	}
    	System.out.println("No staff found with Login Id: " + loginId);
    }
    
    
    /**
     *<li>Method takes in the inputed New Name of the User Account and changes the Original
     *<li>Displays name before and after change, and asks for confirmation. Replying "No" to confirmation will not change the original Name 
     * @param sc Scanner object
     * @param user User object that is to be edited
     */
    public void editName(Scanner sc, User user) {
    	System.out.print("Enter new Name: ");
    	if (sc.hasNextLine()) sc.nextLine();
    	String newName = sc.nextLine();
    	System.out.println("Old: " + user.getName() + " > New: " + newName);
    	System.out.println("Confirm?");
    	System.out.println("1. Yes");
    	System.out.println("2. No");
    	int choice = sc.nextInt();
    	if (choice != 1) return;
    	Staff staff = getStaff(user);
    	if (staff == null) {
    		System.err.println("Error changing Name: Staff not found in branch");
    		return;
    	}
    	staff.setName(newName);
    	user.setName(newName);
    	System.out.println("Name changed");
    }
    
    
    /**
     *<li>Method takes in the inputed New UserId of the User Account and changes the original
     *<li>Displays UserID before and after change, and asks for confirmation. Replying "No" to confirmation will not change the original UserID 
     * @param sc Scanner object
     * @param user User object that will be edited 
     */
    public void editLoginId(Scanner sc, User user) {
    	System.out.print("Enter new Login ID: ");
    	if (sc.hasNextLine()) sc.nextLine();
    	String newId = sc.nextLine();
    	System.out.println("Old: " + user.getUserId() + " > New: " + newId);
    	System.out.println("Confirm?");
    	System.out.println("1. Yes");
    	System.out.println("2. No");
    	int choice = sc.nextInt();
    	if (choice != 1) return;
    	Staff staff = getStaff(user);
    	if (staff == null) {
    		System.err.println("Error changing Login ID: Staff not found in branch");
    		return;
    	}
    	staff.setUserId(newId);
    	user.setUserId(newId);
    	System.out.println("Login ID changed");
    }
    
//    public void editPassword(Scanner sc, User user) {
//    	System.out.print("Enter new Password: ");
//    	if (sc.hasNextLine()) sc.nextLine();
//    	String newPassword = sc.nextLine();
//    	System.out.println("Old: " + user.getPassword() + " > New: " + newPassword);
//    	System.out.println("Confirm?");
//    	System.out.println("1. Yes");
//    	System.out.println("2. No");
//    	int choice = sc.nextInt();
//    	if (choice != 1) return;
//    	Staff staff = getStaff(user);
//    	if (staff == null) {
//    		System.err.println("Error changing Password: Staff not found in branch");
//    		return;
//    	}
//    	staff.setPassword(newPassword);
//    	user.setPassword(newPassword);
//    	System.out.println("Password changed");
//    }
    
//    public void editRole(Scanner sc, User user) {
//    	Staff staff = (Staff)user;
//    	Branch branch =  staff.getBranch();
//		System.out.println("manager quota: " + staff.getBranch().getManagerQuota());
//    	if (user.getUserType() == UserType.STAFF) {
//    		System.out.println("Promote " + user.getName() + " to Manager?");
//    		System.out.println("1. Yes");
//    		System.out.println("2. No");
//    		int choice = sc.nextInt();
//    		if (choice != 1) return;
//    		// need to check whether quota has been reach
//    	}
//    }
    
    
    /**
     *<li>Method takes in the inputed New Gender of the User Account and changes the original
     *<li>Displays Gender before and after change, and asks for confirmation. Replying "No" to confirmation will not change the original Gender 
     * @param sc Scanner object
     * @param user User object that will be edited
     */
    public void editGender(Scanner sc, User user) {
    	if (user.getGender() == Gender.MALE) {
    		System.out.println("Switch to FEMALE?");
        	System.out.println("1. Yes");
    		System.out.println("2. No");
    		int choice = sc.nextInt();
    		if (choice != 1) return;
    		Staff staff = getStaff(user);
    		if (staff == null) {
        		System.err.println("Error changing Gender: Staff not found in branch");
        		return;
        	}
    		staff.setGender(Gender.FEMALE);
    		user.setGender(Gender.FEMALE);
    		System.out.println("Gender changed");
    	} else if (user.getGender() == Gender.FEMALE) {
    		System.out.println("Switch to MALE?");
        	System.out.println("1. Yes");
    		System.out.println("2. No");
    		int choice = sc.nextInt();
    		if (choice != 1) return;
    		Staff staff = getStaff(user);
    		if (staff == null) {
        		System.err.println("Error changing Gender: Staff not found in branch");
        		return;
        	}
    		staff.setGender(Gender.MALE);
    		user.setGender(Gender.MALE);
    		System.out.println("Gender changed");
    	}
    }
    
    
    /**
     *<li>Method takes in the inputed New Age of the User Account and changes the original
     *<li>Displays Age before and after change, and asks for confirmation. Replying "No" to confirmation will not change the original Age 
     * @param sc Scanner object
     * @param user User object that will be edited
     */
    public void editAge(Scanner sc, User user) {
    	System.out.print("Enter new Age: ");
    	if (sc.hasNextLine()) sc.nextLine();
    	int newAge = sc.nextInt();
    	System.out.println("Old: " + user.getAge() + " > New: " + newAge);
    	System.out.println("Confirm?");
    	System.out.println("1. Yes");
    	System.out.println("2. No");
    	int choice = sc.nextInt();
    	if (choice != 1) return;
    	Staff staff = getStaff(user);
    	if (staff == null) {
    		System.err.println("Error changing Age: Staff not found in branch");
    		return;
    	}
    	staff.setAge(newAge);
    	user.setAge(newAge);
    	System.out.println("Age changed");
    }

    
    /**
     * Returns the specific Staff/Manager object of the input User 
     * @param user User that will be retrieved from DataBase as Staff or Manager
     * @return Returns a staff/manager object of the input User 
     */
    public Staff getStaff(User user) {
    	Staff staff = (Staff)user;
		Branch branch = staff.getBranch();
    	if (user.getUserType() == UserType.STAFF) {
			int index = branch.getStaffList().indexOf(staff);
			if (index != -1) {
				return branch.getStaffList().get(index);
			}
		} else if (user.getUserType() == UserType.MANAGER) {
			int index = branch.getManagerList().indexOf(staff);
			if (index != -1) {
				return branch.getManagerList().get(index);
			}
		}
    	return null;
    }
    
    
    /**
     * <li>Facilitates the removal of the account from the DataBase
     * <li>Throws error if LoginId representing staff to be removed does not exist
     * <li>Asks for confirmation for removal of staff
     * <li>Also removes staff from the Branch it was in 
     */
    public void removeAccount() {
    	System.out.println("Enter Login Id of account to remove: ");
    	if (sc.hasNextLine()) sc.nextLine();
    	String loginId = sc.nextLine();
    	
    	User user = getUser(loginId);
    	if (user == null) {
         	System.out.println("No staff found with Login Id: " + loginId);
         	return;
     	} else if (user.getUserType() == UserType.ADMINISTRATOR) {
    		System.out.println("Unable to remove Admin");
    		return;
    	}
    	System.out.println("Confirm?");
    	System.out.println("1. Yes");
    	System.out.println("2. No");
//    	if (sc.hasNextLine()) sc.nextLine();
    	int choice = sc.nextInt();
    	if (choice != 1) return;
    	
    	Staff staff = (Staff)user;
		Branch b = staff.getBranch();
		if (staff.getUserType() == UserType.STAFF) {
			b.getStaffList().remove(staff);
			accountList.remove(staff);
			System.out.println("Staff account removed");
			return;
		} else if (staff.getUserType() == UserType.MANAGER) {
			b.getManagerList().remove(staff);
			accountList.remove(staff);
			System.out.println("Staff account removed");
			return;
		}
    }
}
