package filter;

import java.util.ArrayList;
import java.util.Scanner;

import branch.Branch;
import system.Database;
import system.User;
import system.User.Gender;
import system.User.UserType;

public class Filter {
	private Scanner sc;
	private ArrayList<User> accounts;
	private Database database;
	
	public Filter(Scanner sc, ArrayList<User> accounts, Database database) {
		this.sc = sc;
		this.accounts = accounts;
		this.database = database;
	}
	
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
