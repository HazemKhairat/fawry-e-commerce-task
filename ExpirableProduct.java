import java.time.LocalDate;

public class ExpirableProduct extends Product
{
	private LocalDate expirationDate;

	// Constractor
	public ExpirableProduct(String name, int price, int quantity, LocalDate expirationDate) {
		super(name, price, quantity, 0);
		this.expirationDate = expirationDate;
	}


	// Overloaded Constractor (Shippable)
	public ExpirableProduct(String name, int price, int quantity, LocalDate expirationDate, double weight) {
		super(name, price, quantity, weight);
		this.expirationDate = expirationDate;
	}


	// Expiration method
	@Override
	public boolean isExpired() {
		return expirationDate.isBefore(LocalDate.now());
	}


}