package Model;

public class Item {

	private String itemID;
	private int qty;
	private double unitPrice;
	private String description;
	
	public Item() {
		
	}
	
	public Item(String itemID, int qty, double unitPrice, String description) {
		super();
		this.itemID = itemID;
		this.qty = qty;
		this.unitPrice = unitPrice;
		this.description = description;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", qty=" + qty + ", unitPrice=" + unitPrice + ", description=" + description
				+ "]";
	}
	
	
}
