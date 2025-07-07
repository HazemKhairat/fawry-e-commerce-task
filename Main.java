import java.time.LocalDate;
import java.util.*;


public class Main
{
	public static void checkOut(Customer customer, Cart cart) {
		final double SHIPPING_FEES = 30.0;
		double subTotal = 0;
		double amount = 0;

		// Empty Cart error
		if(cart.size() == 0) {
			System.out.println("Cart is empty, add products and try again");
			return;
		}

		System.out.println("** Checkout receipt ** ");

		Map<Product, Integer> cartItems = cart.getProducts();


		for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
			Product product = entry.getKey();
			int quantity = entry.getValue();
			double price = quantity * product.getProductPrice();
			subTotal += price;
			System.out.println(quantity + "x " + product.getProductName() + "   " + price);
		}

		System.out.println("----------------------");

		amount = (subTotal + SHIPPING_FEES);
		if(customer.getBalance() < amount) {
			System.out.println("Customer does not have enough balance");
			return;
		}

		customer.substract(amount);

		System.out.println("Subtotal:         " + subTotal);
		System.out.println("Shipping:         " + SHIPPING_FEES);
		System.out.println("Amount:           " + amount);

	}

	public static void main(String[] args) {

		// Important objects
		Customer customer = new Customer("Hazem Khairat", 55000);
		Cart cart = new Cart();
		
		
		Product cheese = new ExpirableProduct("Cheese", 50, 100, LocalDate.of(2025, 7, 1), 10.15); 
		
		// shippable product -> (String name, int price, int quantity, double weight)
		Product tv = new NonExpirableProduct("TV", 2000, 10, 150.10);
		Product mobile = new NonExpirableProduct("Mobile", 100, 10, 800);
		
		// non shippable product -> (String name, int price, int quantity)
		Product scratchCard = new NonExpirableProduct("Scratch Card", 100, 10); 


		// test expired product
		cart.add(cheese, 2);
		// test valid amount
		cart.add(mobile, 15);
		System.out.println("----------------------");
		// test valid products
		cart.add(tv, 3);
		cart.add(scratchCard, 1);

		// check out process
		checkOut(customer, cart);
		System.out.println("----------------------");
		System.out.println("customer current balance: " + customer.getBalance());

	}
}
