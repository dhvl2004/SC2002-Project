package project;

import java.io.IOException;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String directory = System.getProperty("user.dir");
		String filename = directory + "/resources/menu_list(1).csv";
		try {
			ItemDB.loadItems(filename);
			Item.itemSet.add(new Item(1, "FRIES", 3.2, "NTU", "side", 2, "Cut Potato"));
			Item.printItems();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException: " + e.getMessage());
		}
	}

}
