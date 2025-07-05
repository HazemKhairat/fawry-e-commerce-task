import java.util.*;

public class Cart {

	private Map<Product, Integer> cartItems;

	public Cart() {
		this.cartItems = new HashMap<>();
	}

	public void add(Product product, int quantity) {
	    
	    // Expired prodcut error handling and quantity validation
		if (product.isExpired()) {
			System.out.println(product.getProductName() + " is expired. Cannot add to cart.");
			return;
		}
		else if (quantity > product.getProductQuantity()) {
			System.out.println("Not enough quantity for " + product.getProductName());
			return;
		}
		else {
			this.cartItems.put(product, quantity);
		}
	}

	public Map<Product, Integer> getProducts() {
		return this.cartItems;
	}

	public int getQuantity(Product product) {
		return this.cartItems.getOrDefault(product, 0);
	}

	public int size() {
		return this.cartItems.size();
	}

}