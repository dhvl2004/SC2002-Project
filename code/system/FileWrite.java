package system;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import branch.Branch;
import item.Item;


/**
 * Class design for writing all data collected during UI runtime to CSV DataBase
 *  @author FDAB 2
 * @version 1.0
 * 
 */
public class FileWrite {
	private static final String directory = System.getProperty("user.dir") + "/resources/";
	private static final String SEPARATOR = ",";
	
	
	/**
	 * <li>This class writes to the CSV Database the information of all branches(name,location,staff quota,etc.) inputed
	 * <li>The information are inputed as strings in separate cells within the CSV file 
	 * @param filename Takes in the name of the file to be written to and read from
	 * @throws IOException Throws exception if reading or writing from the file incurs error
	 */
	public static void saveBranches(String filename) throws IOException {
		List<String> alw = new ArrayList<String>();
		
		alw.add("Name,Location,Staff Quota,OperationStatus");
		for (Branch branch : Database.branchList) {
			StringBuilder st = new StringBuilder();
			
			st.append(branch.getBranchName().trim());
			st.append(SEPARATOR);
			st.append(branch.getBranchLocation().trim());
			st.append(SEPARATOR);
			st.append(branch.getStaffQuota());
			st.append(SEPARATOR);
			st.append(branch.getOperationStatus().name());
			alw.add(st.toString());
		}
		write(filename, alw);
	}
	
	
	/**
	 * <li>This class writes to the CSV Database all account information(name,gender,password,etc.) inputed
	 * <li>The information are inputed as strings in separate cells within the CSV file 
	 * @param filename Filename where the Data comes from
	 * @throws IOException Throws exception if reading or writing from the file incurs error
	 */
	public static void saveAccounts(String filename) throws IOException {
		List<String> alw = new ArrayList<String>();
		
		alw.add("Name,Staff Login ID,Password,Role,Gender,Age,Branch");
		for (User user : Database.accountList) {
			StringBuilder st = new StringBuilder();
			
			st.append(user.getName().trim());
			st.append(SEPARATOR);
			st.append(user.getUserId().trim());
			st.append(SEPARATOR);
			st.append(user.getPassword().trim());
			st.append(SEPARATOR);
			st.append(user.getUserType().name());
			st.append(SEPARATOR);
			st.append(user.getGender().name());
			st.append(SEPARATOR);
			st.append(user.getAge());
			st.append(SEPARATOR);
			st.append(user.getBranchName().trim());
			alw.add(st.toString());
		}
		write(filename, alw);
	}
	
	
	/**
	 * <li>This class writes to the CSV Database all item information(name,quantity,price,etc.) inputed
	 * <li>The information are inputed as strings in separate cells within the CSV file 
	 * @param filename Filename where the Data comes from
	 * @throws IOException Throws exception if reading or writing from the file incurs error
	 */
	public static void saveItems(String filename) throws IOException {
		List<String> alw = new ArrayList<String>();
		
		alw.add("ItemId,Name,Price,Branch,Category,Description");
		for (Branch branch : Database.branchList) {
			for (Item item : branch.getItemList()) {
				StringBuilder st = new StringBuilder();			
				
				st.append(item.getId().trim());
				st.append(SEPARATOR);
				st.append(item.getName().trim());
				st.append(SEPARATOR);
				st.append(item.getPrice());
				st.append(SEPARATOR);
				st.append(branch.getBranchName().trim());
				st.append(SEPARATOR);
				st.append(item.getCategory().name());
				st.append(SEPARATOR);
				st.append(item.getDescription().trim());
				alw.add(st.toString());
			}
		}
		write(filename, alw);
	}

	
	/**
	 * File writes and transfers all information in input list into the target CSV file
	 * @param fileName File that receives the information and data to be written
	 * @param data List of data to be stored in individual cells in CSV DataBase
	 * @throws IOException Throws exception if reading or writing from the file incurs error
	 */
	private static void write(String fileName, List<String> data) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(directory + fileName));
		
		try {
			for (int i = 0; i < data.size(); i++) {
				out.println((String)data.get(i));
			}
		} finally {
			out.close();
		}
	}
}
