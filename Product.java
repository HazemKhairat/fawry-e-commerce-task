
public abstract class Product
{
	protected String name;
	protected int price;
	protected int quantity;
	protected double weight = 0;

	public Product(String name, int price, int quantity, double weight) {
		if(price < 0 | quantity < 0 | weight < 0) {
			System.out.println("Only positive values allowed");
		}
		else {
			this.name = name;
			this.price = price;
			this.quantity = quantity;
			this.weight = weight;
		}
	}

	// getters methods
	public String getProductName() {
		return this.name;
	}

	public int getProductPrice() {
		return this.price;
	}

	public int getProductQuantity() {
		return this.quantity;
	}

	public boolean isShippable() {
		return this.weight > 0;
	}

	public abstract boolean isExpired();

}