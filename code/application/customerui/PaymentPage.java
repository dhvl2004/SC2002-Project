package application.customerui;

import java.util.Random;
import java.util.Scanner;

import cart.Cart;
import order.Order;
import order.Order.DiningOption;
import payment.CardPaymentMode;
import payment.OnlinePaymentMode;
import payment.PaymentMode;

class PaymentPage {
    private DiningOption diningOption;
    private PaymentMode paymentMode;
    private boolean successPayment = false;
    private Order order;
    private int orderId;

    PaymentPage(Scanner sc, int orderId, Cart cart) {
    	this.orderId = orderId;
        System.out.println("Please choose your dining option:");
        System.out.println("1. Dine In");
        System.out.println("2. Takeaway");
        System.out.print("Enter your choice: ");
        int diningOptionChoice = sc.nextInt();
        switch (diningOptionChoice) {
            case 1:
                diningOption = DiningOption.DINE_IN;
                break;
            case 2:
                diningOption = DiningOption.TAKEAWAY;
                break;
        }

        System.out.println("Please choose your payment mode:");
        System.out.println("1. Online Payment");
        System.out.println("2. Card Payment");
        int paymentModeChoice = sc.nextInt();
        Order.PaymentMode pm = Order.PaymentMode.ONLINE;
        switch (paymentModeChoice) {
            case 1:
                paymentMode = new OnlinePaymentMode();
                pm = Order.PaymentMode.ONLINE;
                break;
            case 2:
                paymentMode = new CardPaymentMode();
                pm = Order.PaymentMode.CARD;
                break;
        }
        successPayment = true;
        this.order = new Order(this.generateOrderId(5), cart.getCartItemList(), diningOption, paymentMode);
    }

    public boolean isSuccessPayment() {
        return successPayment;
    }

    public Order getOrder() {
        return order;
    }
    public String generateOrderId(int orderIdLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(orderIdLength);
        for (int i = 0; i < orderIdLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
            (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }
}
