package vo;

public class OrderPrice extends Order {
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public OrderPrice(int price) {
		super();
		this.price = price;
	}
	public OrderPrice() {}

}
