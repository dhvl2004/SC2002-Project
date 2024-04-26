package application.customerui;

import java.util.Random;
import java.util.Scanner;

import cart.Cart;
import order.Order;
import order.Order.DiningOption;
import payment.CardPaymentMode;
import payment.OnlinePaymentMode;
import order.Order.PaymentMode;


/**
 * <li>Class serves as a UI Page for Customer to decide to how they wish to dine and their payment preference
 * <li>This UI comes subsequently after customer has checkout on the "OderingPage" UI
 * @author FDAB 2
 * @version 1.0
 */
class PaymentPage {
	
	/**
	 * Enum Class variable denoting Dining preference of the Customer
	 */
    private DiningOption diningOption;
    
    /**
     * * Enum Class variable denoting Payment preference of the Customer
     */
    private PaymentMode paymentMode;
    private boolean successPayment = false;
    
    /**
     * Order of the current customer interacting with this UI Page
     */
    private Order order;

    
    /**
     * <li>Constructor for PaymentPage class, creating the object will generate a UI page for customer \
     * <li> This UI page will request for dining and payment preference from the customer and call the respective functions for the customer class
     * @param sc scanner object
     * @param cart Cart containing all food orders from customer
     */
    PaymentPage(Scanner sc, Cart cart) {
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
        switch (paymentModeChoice) {
            case 1:
                paymentMode = Order.PaymentMode.ONLINE;
                break;
            case 2:
                paymentMode = Order.PaymentMode.CARD;
                break;
        }
        successPayment = true;
        this.order = new Order(this.generateOrderId(5), cart.getCartItemList(), diningOption, paymentMode);
    }

    
    /**
     * Method determines if the payment is successful or not
     * @return successPayment attribute denoting success of the payment 
     */
    public boolean isSuccessPayment() {
        return successPayment;
    }

    /**
     * Getter function for retrieving the order of the current customer 
     * @return Order object containing all food items customer has ordered
     */
    public Order getOrder() {
        return order;
    }

    
    /**
     * <li> The Method generates a random number that represents customers unique orderID
     * <li> Generation is done by generating random numbers and appending a random letter
     * @param orderIdLength Length of the orderID to be generated
     * @return A randomly generated orderID for customers to track their order
     */
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
