package application.customerui;

import order.Order;
import order.OrderDisplay;

class ReceiptPrintingPage {
    ReceiptPrintingPage(Order order) {
        new OrderDisplay(order);
    }
}
