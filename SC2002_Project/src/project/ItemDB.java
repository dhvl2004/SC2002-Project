package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ItemDB {
	public static final String SEPARATOR = ",";
	public static final String ITEM_HEADER = "ItemId,Name,Price,Branch,Category,Quantity,Description";
	
	public static ArrayList readItems(String filename) throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		ArrayList alr = new ArrayList() ;// to store Items data
//		String itemsHeader = (String)stringArray.get(0);
		
		for (int i = 1; i < stringArray.size(); i++) {
			String st = (String)stringArray.get(i);
			// get individual 'fields' of the string separated by SEPARATOR
			StringTokenizer star = new StringTokenizer(st, SEPARATOR);
			
			int itemId = Integer.parseInt(star.nextToken().trim());
			String name = star.nextToken().trim();
			Double price = Double.parseDouble(star.nextToken().trim());
			String branch = star.nextToken().trim();
			String category = star.nextToken().trim();
			int quantity = Integer.parseInt(star.nextToken().trim());
			String description = star.nextToken().trim();
			
			Item item = new Item(itemId, name, price, branch, category, quantity, description);
			alr.add(item);
		}
		return alr;
	}
	
	public static void saveItems(String filename, List al) throws IOException {
		List alw = new ArrayList();	// to store Item data
		
		alw.add(ITEM_HEADER);
		for (int i = 0; i < al.size(); i++) {
			Item item = (Item)al.get(i);
			StringBuilder st = new StringBuilder();
			st.append(item.getItemId());
			st.append(SEPARATOR);
			st.append(item.getItemName().trim());
			st.append(SEPARATOR);
			st.append(item.getItemPrice());
			st.append(SEPARATOR);
			st.append(item.getItemBranch().trim());
			st.append(SEPARATOR);
			st.append(item.getItemCategory().trim());
			st.append(SEPARATOR);
			st.append(item.getItemQuantity());
			st.append(SEPARATOR);
			st.append(item.getItemDescription().trim());
//			st.append(SEPARATOR);
			alw.add(st.toString());
		}
		write(filename, alw);
	}
	
	public static List read(String fileName) throws IOException {
		List data = new ArrayList();
		Scanner scanner = new Scanner(new FileInputStream(fileName));
//		if (scanner.hasNextLine()) scanner.nextLine();	// to remove csv header
		try {
			while (scanner.hasNextLine()) data.add(scanner.nextLine());
		} finally {
			scanner.close();
		}
		return data;
	}
	
	public static void write(String fileName, List data) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(fileName));
		
		try {
			for (int i = 0; i < data.size(); i++) {
				out.println((String)data.get(i));
			}
		} finally {
			out.close();
		}
	}
	
	public static void main(String[] aArgs) {
//		ItemDB itemDB = new ItemDB();	// not used, not necessary for static
		final String directory = System.getProperty("user.dir");
		String filename = directory + "/resources/menu_list(1).csv";
		try {
			ArrayList al = ItemDB.readItems(filename);
			for (int i = 0; i < al.size(); i++) {
				Item item = (Item)al.get(i);
				System.out.println("ItemID: " + item.getItemName());
			}
			Item item = new Item(1, "FRIES", 3.5, "JP", "side", 9, "Cut Potato");
//			al.add(item);
			ItemDB.saveItems(filename, al);
		} catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}
}
