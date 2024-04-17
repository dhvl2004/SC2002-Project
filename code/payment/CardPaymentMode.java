package payment;

public class CardPaymentMode implements PaymentMode {
    private static boolean available = true; 

    public boolean processPayment(double amount) {
        if (available) {
            System.out.println("Successfully paid $" + amount + " using debit/credit card payment");
            return true;
        } else {
            System.out.println("Debit/Credit card payment method is currently unavailable. Please try another payment method.");
            return false;
        }
    }

    protected static void setAvailability(boolean available) {
        CardPaymentMode.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

}
