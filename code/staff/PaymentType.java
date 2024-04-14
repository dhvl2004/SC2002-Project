package staff;

public interface PaymentType {
    public boolean processPayment(double amount);
    boolean isAvailable();
}
