package filter;

import java.util.ArrayList;
import java.util.Scanner;

import branch.Branch;
import system.Database;
import system.User;
import system.User.Gender;
import system.User.UserType;


/**
 * Allows Specified selection of Users based on specified attributes
 * <li>This helps provide information of user's with only attribute(specified by user)
 * <li>For example: to filter out all staff by age
 * @author FDAB
 * @version 1.0
 */
public class Filter {
	private Scanner sc;
	
	/**
	 * All accounts within the DataBase
	 */
	private ArrayList<User> accounts;
	private Database database;
	
	
	/**
	 * Constructor for the filter class
	 * @param sc Scanner object
	 * @param accounts List of all accounts involved
	 * @param database Database storing all user's information
	 */
	public Filter(Scanner sc, ArrayList<User> accounts, Database database) {
		this.sc = sc;
		this.accounts = accounts;
		this.database = database;
	}
	
	
	/**
	 * Method Filters all users by their role(staff or manager)
	 * @return A list of all the users fulfilling the specified condition
	 */
	public ArrayList<User> roleFilter() {
    	ArrayList<User> filteredList = new ArrayList<User>();
    	
		// Roles hard-coded cause no requirements to add other roles
    	System.out.println("Select Role to filter");
		System.out.println("1. Staff");
		System.out.println("2. Manager");
		System.out.println("3. Cancel");
    	if (sc.hasNextLine()) sc.nextLine();
    	int filter = sc.nextInt();
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
    
	
	/**
	 * Method Filters all users by their Branch
	 * @return A list of all the users of the same branch 
	 */
    public ArrayList<User> branchFilter() {
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
    
    
    /**
     * Method Filters all users by their Gender
	 * @return A list of all the users filtered by their gender
     * 
     */
    public ArrayList<User> genderFilter() {
    	ArrayList<User> filteredList = new ArrayList<User>();
    	
    	System.out.println("Select Gender to filter");
		System.out.println("1. Male");
		System.out.println("2. Female");
		System.out.println("3. Cancel");
		if (sc.hasNextLine()) sc.nextLine();
    	int filter = sc.nextInt();
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
    
    
    /**
     *  Method Filters all users by their Age
	 * @return A list of all the users filtered by their Age
     */
    public ArrayList<User> ageFilter() {
    	ArrayList<User> filteredList = new ArrayList<User>();
    	
    	System.out.print("Enter Age limit to filter: ");
		if (sc.hasNextLine()) sc.nextLine();
		int age = sc.nextInt();
    	for (User user : accounts) {
    		if (user.getAge() <= age) filteredList.add(user);
    	}
    	return filteredList;
    }
}
