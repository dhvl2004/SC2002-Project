package application.customerui;

import java.util.ArrayList;

import item.Item;

class CartPage {
    private ArrayList<Item> cart;

    CartPage(ArrayList<Item> cart) {
        this.cart = cart;
    }

    public void displayCart() {
        System.out.println("ID\t\tName\t\tPrice\t\tCategory\t\t");
        for (Item item: this.cart) {
            System.out.println(item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getCategory());
        }
    }
}
