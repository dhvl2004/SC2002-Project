package system;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import admin.Admin;
import branch.Branch;
import branch.ItemManagement;
import branch.Branch.OperationStatus;
import item.Item;
import item.Item.Category;
import staff.Manager;
import staff.Staff;
import system.User.Gender;


/**
 * Class is designed to facilitate reading in from the CSV DataBase
 *  @author FDAB 2
 * @version 1.0
 * 
 */
public class FileRead {
	private static final String directory = System.getProperty("user.dir") + "/resources/";
	private static final String SEPARATOR = ",";
	
	
	/**
	 * <li>This method reads in all information of Branches from CSV Database and stores branch objects into input arrayList of branches
	 * <li> Method should give arraylist of all branches with their respective information 
	 * @param filename Name of the CSV file to be read
	 * @param branchList ArrayList of branches.
	 * @throws IOException Throws exception if reading or writing from the file incurs error
	 */
	public static void loadBranches(String filename, ArrayList<Branch> branchList) throws IOException {
		// read String from text file
		ArrayList<String> stringArray = (ArrayList<String>)read(filename);
		
		for (int i = 1; i < stringArray.size(); i++) {
			String st = (String)stringArray.get(i);
			// get individual 'fields' of the string separated by SEPARATOR
			StringTokenizer star = new StringTokenizer(st, SEPARATOR);
			
			String name = star.nextToken().trim();
			String location = star.nextToken().trim();
			int staffQuota = Integer.parseInt(star.nextToken().trim());
			String operationStatus = star.nextToken().trim().toUpperCase();
			
			try {
				OperationStatus os = OperationStatus.valueOf(operationStatus);
				Branch branch = new Branch(name, location, staffQuota, os);
				branchList.add(branch);
			} catch (IllegalArgumentException e) {
				System.err.println("Error creating Branch object: " + e.getMessage());
			}
		}
	}
	
	
	/**
	 * <li>This method reads in all information of Users from CSV Database and stores User objects into input arrayList
	 * <li> Method should result in an arraylist of all users with their respective information 
	 * @param filename Name of the CSV file to be read
	 * @param branchList ArrayList of Users.
	 * @throws IOException Throws exception if reading or writing from the file incurs error
	 */
	public static void loadAccounts(String filename, ArrayList<User> accountList) throws IOException {
		// read String from text file
		ArrayList<String> stringArray = (ArrayList<String>)read(filename);
		
		for (int i = 1; i < stringArray.size(); i++) {
			String st = (String)stringArray.get(i);
			// get individual 'fields' of the string separated by SEPARATOR
			StringTokenizer star = new StringTokenizer(st, SEPARATOR);
			
			String name = star.nextToken().trim();
			String loginId = star.nextToken().trim();
			String password = star.nextToken().trim();
			String role = star.nextToken().trim().toUpperCase();
			char roleChar = role.toCharArray()[0];
			String gender = star.nextToken().trim();
			int age = Integer.parseInt(star.nextToken().trim());
			String branch = star.nextToken().trim();
			
			if (loginId.equalsIgnoreCase("boss")) {
				try {
					Admin admin = new Admin(loginId, password, name, Gender.valueOf(gender), age, branch);
					accountList.add(admin);
					continue;
				} catch (IllegalArgumentException e) {
					System.err.println("Error creating Admin object: " + e.getMessage());
				}
			}
			
			try {
				Branch b = Database.findBranch(branch);
				Gender g = Gender.valueOf(gender);

				switch (roleChar) {
					case 'S':
						Staff staff = new Staff(b, loginId, password, name, g, age);
						accountList.add(staff);
						b.getStaffList().add(staff);
						break;
					case 'M':
						Manager manager = new Manager(b, loginId, password, name, g, age);
						accountList.add(manager);
						b.getManagerList().add(manager);
						break;
				}
			} catch (IllegalArgumentException e) {
				System.err.println("Error creating Staff object: " + e.getMessage());
			} catch (BranchNotFoundException e) {
				System.err.println("Error creating Staff object: " + e.getMessage());
			}
		}
	}
	
	
	/**
	 * <li>This method reads in all information of Items from CSV Database and stores Items objects into input arrayList
	 * <li> Method should result in an arraylist of all Items with their respective information 
	 * @param filename Name of the CSV file to be read
	 * @param branchList ArrayList of Items.
	 * @throws IOException Throws exception if reading or writing from the file incurs error
	 */
	public static void loadItems(String filename, ArrayList<Branch> branchList) throws IOException {
		ArrayList<String> stringArray = (ArrayList<String>)read(filename);
		
		for (int i = 1; i < stringArray.size(); i++) {
			String st = (String)stringArray.get(i);
			// get individual 'fields' of the string separated by SEPARATOR
			StringTokenizer star = new StringTokenizer(st, SEPARATOR);
			
			String itemId = star.nextToken().trim();
			String name = star.nextToken().trim();
			Double price = Double.parseDouble(star.nextToken().trim());
			String branch = star.nextToken().trim();
			String category = star.nextToken().trim().toUpperCase();
			String description = star.nextToken().trim();
			
			try {
				Branch b = Database.findBranch(branch);
				Category c = Category.valueOf(category);
				Item item = new Item(itemId, name, price, c, description);
				ItemManagement itemManagement = new ItemManagement(b);
				itemManagement.addItem(item);
			} catch (IllegalArgumentException e) {
				System.err.println("Error creating Staff object: " + e.getMessage());
			} catch (BranchNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}
	}
	
	
	/**
	 * This method facilitates reading of the CSV file to retrieve it,s cell values
	 * @param fileName Name of CSV file to be read from
	 * @return String of all data read from the CSV file
	 * @throws IOException Throws exception if reading or writing from the file incurs error
	 */
	private static List<String> read(String fileName) throws IOException {
		List<String> data = new ArrayList<String>();
		Scanner scanner = new Scanner(new FileInputStream(directory + fileName));
//		if (scanner.hasNextLine()) scanner.nextLine();	// to remove csv header
		try {
			while (scanner.hasNextLine()) data.add(scanner.nextLine());
		} finally {
			scanner.close();
		}
		return data;
	}
}
