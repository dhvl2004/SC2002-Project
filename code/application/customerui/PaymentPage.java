package application.customerui;

import java.util.Scanner;

import cart.Cart;

class PaymentPage {
    private boolean successPayment = false;
    PaymentPage(Scanner sc, Cart cart) {
        System.out.println("Please choose your payment method");
    }

    public boolean isSuccessPayment() {
        return successPayment;
    }
}
