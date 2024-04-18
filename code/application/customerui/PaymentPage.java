package application.customerui;

import java.util.ArrayList;

import item.Item;

class PaymentPage {
    private boolean successPayment = false;
    PaymentPage(ArrayList<Item> cart) {
        
    }

    public boolean isSuccessPayment() {
        return successPayment;
    }
}
