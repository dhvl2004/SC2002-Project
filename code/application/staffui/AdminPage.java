package application.staffui;

import java.util.ArrayList;
import java.util.Scanner;

import admin.Admin;
import branch.Branch;
import staff.Manager;
import staff.Staff;
import system.AccountManagement;
import system.Database;
import system.User;
import system.User.Gender;
import system.User.UserType;

class AdminPage {
	private Database database;
	private Admin admin;
	
    AdminPage(Scanner sc, Admin admin, Database database) {
    	this.database = database;
    	this.admin = admin;
    	while (true) {
        	System.out.println("\n--------------------");
            System.out.println("LOGIN AS ADMIN");
            System.out.println("--------------------");

            System.out.println("Choose your action:");
            System.out.println("1. Display Staff List");
            System.out.println("2. Add, Edit or Remove Staff Accounts");
            System.out.println("3. Assign Manager");
            System.out.println("4. Promote Staff");
            System.out.println("5. Transfer Staff/Manager");
            System.out.println("6. Add/Remove Payment Method");
            System.out.println("7. Open/Close Branch");
            System.out.println("8. Change Password");
            System.out.println("9. Return to Start");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
            	case 1:
            		displayStaffAccounts(database.getAccountList());
            		chooseFilter(sc, database.getAccountList());
            		break;
                case 2:
                	manageAccounts(sc, database.getAccountList());
                	break;
                case 8:
                	changePassword(sc);
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
    
    private boolean displayStaffAccounts(ArrayList<User> accounts) {
    	if (accounts.isEmpty()) {
    		System.out.println("No accounts found");
    		return false;
    	}
    	for (User user : accounts) {
    		System.out.println("Name: " + user.getName() + 
    				", Login Id: " + user.getUserId() +
    				", Password: " + user.getPassword() +
    				", Role: " + user.getUserType() +
    				", Branch: " + user.getBranchName() +
    				", Gender: " + user.getGender() + 
    				", Age: " + user.getAge());
    	}
    	return true;
    }
    
    private void chooseFilter(Scanner sc, ArrayList<User> accounts) {
    	ArrayList<User> filteredList = new ArrayList<User>();
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
        			// Roles hard-coded cause no requirements to add other roles
        			System.out.println("Select Role to filter");
        			System.out.println("1. Staff");
        			System.out.println("2. Manager");
        			System.out.println("3. Cancel");
        	    	if (sc.hasNextLine()) sc.nextLine();
        	    	filteredList = roleFilter(sc.nextInt(), accounts); 
        	    	displayStaffAccounts(filteredList);
        	    	break;
        		case 2:
        			filteredList = branchFilter(sc, accounts);
        			displayStaffAccounts(filteredList);
        			break;
        		case 3:
        			System.out.println("Select Gender to filter");
        			System.out.println("1. Male");
        			System.out.println("2. Female");
        			System.out.println("3. Cancel");
        			if (sc.hasNextLine()) sc.nextLine();
        			filteredList = genderFilter(sc.nextInt(), accounts);
        			displayStaffAccounts(filteredList);
        			break;
        		case 4:
        			System.out.print("Enter Age limit to filter: ");
        			if (sc.hasNextLine()) sc.nextLine();
        			int age = sc.nextInt();
        			filteredList = ageFilter(age, accounts);
        			displayStaffAccounts(filteredList);
        			break;
        		case 5:
    			default:
    				return;
        	}
    	}
    }
    
    private ArrayList<User> roleFilter(int filter, ArrayList<User> accounts) {
    	ArrayList<User> filteredList = new ArrayList<User>();
    	switch (filter) {
    		case 1:
    			for (User user : accounts) {
    				if (user.getUserType() == UserType.STAFF)
    					filteredList.add(user);
    			}
    			return filteredList;
    		case 2:
    			for (User user : accounts) {
    				if (user.getUserType() == UserType.MANAGER)
    					filteredList.add(user);
    			}
    			return filteredList;
			default:
				return accounts;
    	}
    }
    
    private ArrayList<User> branchFilter(Scanner sc, ArrayList<User> accounts) {
    	ArrayList<User> filteredList = new ArrayList<User>();
    	ArrayList<String> branches = new ArrayList<String>();
    	System.out.println("Select Branch to filter");
		int i = 1;
		for (Branch branch : database.getBranchList()) {
			String branchName = branch.getBranchName();
			System.out.println(i++ + ". " + branchName);
			branches.add(branchName);
		}
		System.out.println(i + ". Cancel");
		if (sc.hasNextLine()) sc.nextLine();
		int choice = sc.nextInt() - 1;
		if (choice < 0 || choice >= branches.size()) return accounts;
		for (User user : accounts) {
			if (user.getBranchName().equals(branches.get(choice))) filteredList.add(user);
		}
		return filteredList;
    }
    
    private ArrayList<User> genderFilter(int filter, ArrayList<User> accounts) {
    	ArrayList<User> filteredList = new ArrayList<User>();
    	switch (filter) {
    		case 1:
    			for (User user : accounts) {
    				if (user.getGender() == Gender.MALE)
    					filteredList.add(user);
    			}
    			return filteredList;
    		case 2:
    			for (User user : accounts) {
    				if (user.getGender() == Gender.FEMALE)
    					filteredList.add(user);
    			}
    			return filteredList;
			default:
				return accounts;
    	}
    }
    
    private ArrayList<User> ageFilter(int filter, ArrayList<User> accounts) {
    	ArrayList<User> filteredList = new ArrayList<User>();
    	for (User user : accounts) {
    		if (user.getAge() <= filter) filteredList.add(user);
    	}
    	return filteredList;
    }
    
    private void manageAccounts(Scanner sc, ArrayList<User> accounts) {
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
        			addAccount(sc, accounts);
        			break;
        		case 2:
        			editAccount(sc, accounts);
        			break;
        		case 3:
        			removeAccount(sc, accounts);
        			break;
        		case 4:
    			default:
    				return;
        	}
    	}
    }
    
    private void addAccount(Scanner sc, ArrayList<User> accounts) {
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
    		for (Branch b : database.getBranchList()) {
    			if (branch.equals(b.getBranchName())) {
    				if (role == UserType.STAFF) {
    					Staff user = new Staff(b, loginId, password, name, gender, age);
    					b.getStaffList().add(user);
    					accounts.add(user);
        				System.out.println("Staff account added.");
        				return;
    				} else if (role == UserType.MANAGER) {
    					Manager user = new Manager(b, loginId, password, name, gender, age);
    					b.getStaffList().add(user);
    					accounts.add(user);
        				System.out.println("Staff account added");
        				return;
    				}
    			}
    		}
    		System.out.println("No branch found. Add new branch first before adding account.");
    	} catch (Exception e) {
    		System.err.println("Error creating account: " + e.getMessage());
    	}
    }
    
    private void editAccount(Scanner sc, ArrayList<User> accounts) {
    	displayStaffAccounts(accounts);
    	System.out.println("Enter Login Id of account to edit: ");
    	if (sc.hasNextLine()) sc.nextLine();
    	String loginId = sc.nextLine();
    	for (User user : accounts) {
    		if (loginId.equals(user.getUserId())) {
    			System.out.println("Choose what to edit:");
    			System.out.println("1. Name");
    			System.out.println("2. Login Id");
    			System.out.println("3. Password");
    			System.out.println("4. Role");
    			System.out.println("5. Gender");
    			System.out.println("6. Age");
    			System.out.println("7. Branch");
    			System.out.println("8. Go Back");
    			int choice = sc.nextInt();
    			
    			switch (choice) {
    				case 1:
    					editName(sc, user);
    					return;
    				case 2:
    					editLoginId(sc, user);
    					return;
    				case 3:
    					editPassword(sc, user);
    					return;
    				case 4:
    					editRole(sc, user);
    					return;
    				case 8:
    				default:
    					return;
    			}
    		}
    	}
    	System.out.println("No staff found with Login Id: " + loginId);
    }
    
    private void editName(Scanner sc, User user) {
    	System.out.print("Enter new Name: ");
    	if (sc.hasNextLine()) sc.nextLine();
    	String newName = sc.nextLine();
    	System.out.println("Old: " + user.getName() + " > New: " + newName);
    	System.out.println("Confirm?");
    	System.out.println("1. Yes");
    	System.out.println("2. No");
    	int choice = sc.nextInt();
    	if (choice != 1) return;
    	Staff staff = (Staff)user;
    	Branch branch = staff.getBranch();
    	int staffIndex = branch.getStaffList().indexOf(staff);
    	if (staffIndex != 1) {
    		Staff s = branch.getStaffList().get(staffIndex);
    		s.setName(newName);
        	user.setName(newName);
        	System.out.println("Name changed");
        	return;
    	}
    }
    
    private void editLoginId(Scanner sc, User user) {
    	System.out.print("Enter new Login ID: ");
    	if (sc.hasNextLine()) sc.nextLine();
    	String newId = sc.nextLine();
    	System.out.println("Old: " + user.getUserId() + " > New: " + newId);
    	System.out.println("Confirm?");
    	System.out.println("1. Yes");
    	System.out.println("2. No");
    	int choice = sc.nextInt();
    	if (choice != 1) return;
    	Staff staff = (Staff)user;
    	Branch branch = staff.getBranch();
    	int staffIndex = branch.getStaffList().indexOf(staff);
    	if (staffIndex != 1) {
    		Staff s = branch.getStaffList().get(staffIndex);
    		s.setUserId(newId);
        	user.setUserId(newId);
        	System.out.println("Login ID changed");
        	return;
    	}
    }
    
    private void editPassword(Scanner sc, User user) {
    	System.out.print("Enter new Password: ");
    	if (sc.hasNextLine()) sc.nextLine();
    	String newPassword = sc.nextLine();
    	System.out.println("Old: " + user.getPassword() + " > New: " + newPassword);
    	System.out.println("Confirm?");
    	System.out.println("1. Yes");
    	System.out.println("2. No");
    	int choice = sc.nextInt();
    	if (choice != 1) return;
    	Staff staff = (Staff)user;
    	Branch branch = staff.getBranch();
    	int staffIndex = branch.getStaffList().indexOf(staff);
    	if (staffIndex != 1) {
    		Staff s = branch.getStaffList().get(staffIndex);
    		s.setPassword(newPassword);
        	user.setPassword(newPassword);
        	System.out.println("Password changed");
        	return;
    	}
    }
    
    private void editRole(Scanner sc, User user) {
    	if (user.getUserType() == UserType.STAFF) {
    		System.out.println("Promote " + user.getName() + " to Manager?");
    		System.out.println("1. Yes");
    		System.out.println("2. No");
    		int choice = sc.nextInt();
    		if (choice != 1) return;
    		// need to check whether quota has been reach
    	}
    }
    
    private void removeAccount(Scanner sc, ArrayList<User> accounts) {
    	displayStaffAccounts(accounts);
    	System.out.println("Enter Login Id of account to remove: ");
    	if (sc.hasNextLine()) sc.nextLine();
    	String loginId = sc.nextLine();
    	System.out.println("Confirm?");
    	System.out.println("1. Yes");
    	System.out.println("2. No");
//    	if (sc.hasNextLine()) sc.nextLine();
    	int choice = sc.nextInt();
    	if (choice != 1) return;
    	for (User user : accounts) {
    		if (loginId.equals(user.getUserId())) {
        		Staff staff = (Staff)user;
    			Branch b = staff.getBranch();
    			if (staff.getUserType() == UserType.STAFF) {
    				b.getStaffList().remove(staff);
    				accounts.remove(staff);
    				System.out.println("Staff account removed");
    				return;
    			} else if (staff.getUserType() == UserType.MANAGER) {
    				b.getManagerList().remove(staff);
    				accounts.remove(staff);
    				System.out.println("Staff accounts removed");
    				return;
    			}
    		}
    	}
    	System.out.println("No staff found with Login Id: " + loginId);
    }
    
    private void changePassword(Scanner sc) {
    	System.out.println("---Change Password---");
    	System.out.println("Enter Old Password: ");
    	String oldPassword = sc.next();
    	if (!oldPassword.equals(admin.getPassword())) {
    		System.out.println("Incorrect Old Password");
    		return;
    	}
    	System.out.println("Enter New Password: ");
    	String newPassword1 = sc.next();
    	System.out.println("Confirm New Password: ");
    	String newPassword2 = sc.next();
    	if (newPassword1.equals(newPassword2)) {
    		admin.setPassword(newPassword2);
    		System.out.println("Password has been changed");
    	}
    	else System.out.println("New passwords does not match");
    }
}
