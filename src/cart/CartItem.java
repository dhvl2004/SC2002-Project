package cart;

//=======================================================================
/*	CartItem class	*/
//======================================================================
public class CartItem {
	private int itemId;
	private double price;
	private int quantity;
	private String description;
		
	public CartItem(int itemId, double price, int quantity, String description) {
		this.itemId = itemId;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
	}
	
	public int getItemId() {
		return itemId;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
	
	public String getDescription() {
		return description;
	}
}
