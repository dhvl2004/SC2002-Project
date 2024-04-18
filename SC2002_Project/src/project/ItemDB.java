package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ItemDB {
	public static final String SEPARATOR = ",";
	public static final String ITEM_HEADER = "ItemId,Name,Price,Branch,Category,Quantity,Description";
	
	public static void loadItems(String filename) throws IOException {
		// read String from text file
		ArrayList<String> stringArray = (ArrayList<String>)Database.read(filename);
		
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
			Item.itemSet.add(item);
		}
	}
	
	public static void saveItems(String filename) throws IOException {
		List<String> alw = new ArrayList<String>();	// to store Item data
		
		alw.add(ITEM_HEADER);
		for (Item item : Item.itemSet) {
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
			alw.add(st.toString());
		}
		Database.write(filename, alw);
	}
}
