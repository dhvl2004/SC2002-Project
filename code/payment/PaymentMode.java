package payment;

public interface PaymentMode {
    public boolean processPayment(double amount);
    public void setAvailability(boolean available);
    public boolean isAvailable();
}
