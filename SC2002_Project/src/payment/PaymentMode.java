package payment;


/**
 * 
 * <li> Interface for different payment modes to implement through inheriting/implementing this interface</li>
 * <li>Type : Entity</li>
 * @author FDAB 2
 * @version 1.0
 * @since 23-4-2024
 */
public interface PaymentMode {
	
	/**
	 * Abstract Method for taking in Payment
	 * @param amount Takes in the amount to pay
	 * @return Returns True on successful Payment, False if Payment failed
	 */
    public boolean processPayment(double amount);
    
    /**
     * Method sets the availability attribute of Payment class True/False
     * @param available Boolean representing if Payment option is available or not 
     */
    public void setAvailability(boolean available);
    
    /**
     * Method Checks to see if Payment Method is currently available
     * @return Boolean representing availability of Payment Method - True: Available, False: Unavailable
     */
    public boolean isAvailable();
}
