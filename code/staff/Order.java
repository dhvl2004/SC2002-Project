package staff;
import java.util.InputMismatchException;
import java.util.Scanner;
import item.Item;

public class Order {
    private int orderId;
    private Item[] itemOrdered;
    public enum OrderStatus {NEW, READY_TO_PICKUP, COMPLETED};
    private OrderStatus status;
    private boolean isDiningIn;
    private double price;
    private PaymentType payType;

    public Order(int orderId, Item[] itemOrdered, boolean isDiningIn, double price) {
        this.orderId = orderId;
        this.itemOrdered = itemOrdered;
        this.status = OrderStatus.NEW; 
        this.isDiningIn = isDiningIn;
        this.price = price;
        this.payType = selectPaymentType();
    }

    private PaymentType selectPaymentType() {
        PaymentType card = new CardPaymentPlatform();
        PaymentType online = new OnlinePaymentPlatform();

        System.out.println("Please choose an available payment method:");
        System.out.println("1: Credit/Debit Card Payment" + (card.isAvailable() ? "" : " (Unavailable)"));
        System.out.println("2: Online Payment" + (online.isAvailable() ? "" : " (Unavailable)"));

        Scanner sc = new Scanner(System.in);

        PaymentType selectedPaymentType = null;

        while (selectedPaymentType == null) {
            try {
                int paymentChoice = sc.nextInt();
                switch (paymentChoice) {
                    case 1:
                        if (card.isAvailable()) {
                            selectedPaymentType = card;
                        } else {
                            System.out.println("Credit/Debit card payment is unavailable. Please choose another method: ");
                        }
                        break;
                    case 2:
                        if (online.isAvailable()) {
                            selectedPaymentType = online;
                        } else {
                            System.out.println("Online payment is unavailable. Please choose another method: ");
                        }
                        break;
                    default:
                        System.out.println("Invalid input. Please enter 1 or 2: ");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number: ");
                sc.next(); 
            }
        }

        sc.close();
        return selectedPaymentType;
        
    }

    public Item[]  getItemOrdered() {
        return itemOrdered; 
    }

    Scanner sc = new Scanner(System.in);

    public void getPayment() {
        if (payType.processPayment(price)) {
            System.out.println("Payment processed successfully.");
        } else {
            // if there was a change in availability of a payment method after order was created but before payment was made
            System.out.println("Unable to process payment, please contact customer service.");
        }
    }


    public int getOrderId() {
        return orderId;
    }

    public OrderStatus getOrderStatus() {
        return status;
    }

    public boolean getIsDiningIn() {
        return isDiningIn;
    }


    protected void setReadyToPickup() {
        this.status = OrderStatus.READY_TO_PICKUP;
    }

    protected void setCompleted() {
        this.status = OrderStatus.COMPLETED;
    }



}
