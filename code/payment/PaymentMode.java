package payment;

public interface PaymentMode {
    public boolean processPayment(double amount);
    public boolean isAvailable();
}
