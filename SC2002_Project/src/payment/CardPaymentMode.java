package payment;


/**
 * 
 * <li>CardPaymentMode Inherits from the Abstract class "PaymentMode" </li>
 * <li> The class represents methods facilitating Payment using Card</li>
 * <li>Stereotype: Entity</li>
 * @author FDAB 2
 * @version 1.0
 * @since 23-4-2024
 */
public class CardPaymentMode implements PaymentMode {
	
	/**
	 * "Available" represents if CardPayment is available or not
	 */
    private static boolean available = true;

    
    /**
     * <li>Inherits and Implements "processPayment" method</li>
     * <li>Takes in amount to be paid by Card</li>
     * <li>returns a Boolean. True representing Successful Payment, False representing unsuccessful payment</li>
     */
    public boolean processPayment(double amount) {
        if (available) {
            System.out.println("Successfully paid $" + amount + " using debit/credit card payment");
            return true;
        } else {
            System.out.println("Debit/Credit card payment method is currently unavailable. Please try another payment method.");
            return false;
        }
    }

    
    
    /**
     * <li>Inherits and Implements "setAvailability" method, this method decides if Card Payment is available or not</li>
     * <li>Sets the Availability attribute of the CardPaymentMode Class</li>
     * 
     */
    public void setAvailability(boolean available) {
        CardPaymentMode.available = available;
    }
    
    

    /**
     * <li>Inherits and Implements "isAvailable" method</li>
     * <li>Method Checks to see if Card Payment is available or not </li>
     * 
     */
    public boolean isAvailable() {
        return available;
    }

}
