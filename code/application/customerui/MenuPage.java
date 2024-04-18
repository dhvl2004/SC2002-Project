package application.customerui;

import java.util.ArrayList;

import item.Item;

class MenuPage {
    private ArrayList<Item> menu;

    MenuPage(ArrayList<Item> menu) {
        this.menu = menu;
    }

    public void displayMenu() {
        System.out.println("ID\tName\tPrice\tCategory");
        for (Item item: this.menu) {
            System.out.println(item.getId() + "\t" + item.getName() + "\t" + item.getPrice() + "\t" + item.getCategory());
        }
    }
}
