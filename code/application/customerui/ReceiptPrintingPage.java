package application.customerui;

import order.Order;
import order.OrderDisplay;

/**
 * Class that prints out the receipt for customers to view upon payment 
 * @author FDAB 2
 * @version 1.0
 */
class ReceiptPrintingPage {
	
	/**
	 * Constructor of ReceiptPrintingPage, creating the object will bring users to a UI showing them their receipt.
	 * @param order Final order customer paid for
	 */
    ReceiptPrintingPage(Order order) {
        new OrderDisplay(order);
    }
}
