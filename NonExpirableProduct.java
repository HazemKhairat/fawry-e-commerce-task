
public class NonExpirableProduct extends Product {

	// Constractor
	public NonExpirableProduct(String name, int price, int quantity) {
		super(name, price, quantity, 0);
	}

	// Overloaded Constractor (Shippable)
	public NonExpirableProduct(String name, int price, int quantity, double weight) {
		super(name, price, quantity, weight);
	}

	@Override
	public boolean isExpired() {
		return false;
	}
}