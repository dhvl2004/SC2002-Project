package system;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import branch.Branch;
import item.Item;

public class FileWrite {
	private static final String directory = System.getProperty("user.dir") + "/resources/";
	private static final String SEPARATOR = ",";
	
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
