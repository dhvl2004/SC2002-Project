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

public class AccountManagement {
    private ArrayList<User> accountList;
    private Scanner sc;
    private Database database;

    public AccountManagement(ArrayList<User> accountList) {
        this.accountList = accountList;
    }
    
    public AccountManagement(Scanner sc, ArrayList<User> accounts, Database database) {
    	this.accountList = accounts;
    	this.sc = sc;
    	this.database = database;
    }

    public User getUser(String userId) {
        for (User account : accountList) {
            if (userId.equals(account.getUserId())) {
                return account;
            }
        }
        return null;
    }

    public boolean addUser(User user) {
        if (this.getUser(user.getUserId()) != null) {
            return false;
        }

        this.accountList.add(user);
        return true;
    }

    public User removeUser(String userId) {
        User user = this.getUser(userId);
        if (user == null || user instanceof Admin) {
            return null;
        }

        this.accountList.remove(user);
        return user;
    }

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
