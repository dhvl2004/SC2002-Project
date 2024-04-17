package payment;

public class OnlinePaymentMode implements PaymentMode {
    private static boolean available = true;

    public boolean processPayment(double amount) {
        if (available) {
            System.out.println("Successfully paid $" + amount + " using online payment");
            return true;
        } else {
            System.out.println("Online payment method is currently unavailable. Please try another payment method.");
            return false;
        }
    }

    protected static void setAvailability(boolean available) {
        OnlinePaymentMode.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
}
