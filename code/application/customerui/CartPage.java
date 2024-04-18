package application.customerui;

import java.util.ArrayList;

import item.Item;

class CartPage {
    private ArrayList<Item> cart;

    CartPage(ArrayList<Item> cart) {
        this.cart = cart;
    }

    public void displayCart() {
        System.out.println("ID\tName\tPrice\tCategory\t");
        for (Item item: this.cart) {
            System.out.println(item.getId() + "\t" + item.getName() + "\t" + item.getPrice() + "\t" + item.getCategory());
        }
    }
}
