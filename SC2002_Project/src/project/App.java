package project;

import java.io.IOException;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "menu_list(1).csv";
		try {
			ItemDB.loadItems(filename);
			Item.itemSet.add(new Item(99, "FRIES", 3.2, "NTU", "side", 2, "Cut Potato"));	// duplicates won't be added so it would not be saved also
			ItemDB.saveItems(filename);
			Item.printItems();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException: " + e.getMessage());
		}
		
		
	}

}
