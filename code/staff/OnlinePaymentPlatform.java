package staff;

public class OnlinePaymentPlatform implements PaymentType {
    
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
        OnlinePaymentPlatform.available = available;
    }

    public boolean isAvailable() {
        return available;
    }


}
