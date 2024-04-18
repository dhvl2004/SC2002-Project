package application.customerui;

import java.util.ArrayList;

import item.Item;

class MenuPage {
    private ArrayList<Item> menu;

    MenuPage(ArrayList<Item> menu) {
        this.menu = menu;
    }

    public void displayMenu() {
        System.out.println("ID\t\tName\t\tPrice\t\tCategory");
        for (Item item: this.menu) {
            System.out.println(item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getCategory());
        }
    }
}
