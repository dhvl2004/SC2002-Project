package payment;


/**
 * 
 * <li>Class that inherits from PaymentMode, intended to represent Online Payment  
 * <li>Similar to PaymentMode, it lets customers know if the option is available
 * <li> This class also allows setting availability of online payment option 
 * @author FDAB 2
 * @version 1.0
 */
public class OnlinePaymentMode implements PaymentMode {
	
	/**
	 * Attribute indicating if online payment can be used by customers or not
	 */
    private static boolean available = true;

    
    
    /**
     * Method that facilitates the online transaction between customer and branch
     * @param amount Value of money customer input
     * @return <li>Returns True if payment was successful
     * 		   <li>	Returns False if Payment was not available and hence unsuccessful
     * 
     */
    public boolean processPayment(double amount) {
        if (available) {
            System.out.println("Successfully paid $" + amount + " using online payment");
            return true;
        } else {
            System.out.println("Online payment method is currently unavailable. Please try another payment method.");
            return false;
        }
    }

    
    /**
     * Method changes the availability of the Online Payment Method
     * @param Boolean representing True for available and False for unavailable
     */
    public void setAvailability(boolean available) {
        OnlinePaymentMode.available = available;
    }

    
    /**
     * 
     */
    public boolean isAvailable() {
        return available;
    }
}
