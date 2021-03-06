package br.com.cod3r.iterator.cart;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Client {

	public static void main(String[] args) {
		Cart cart = new Cart(new Product("TV", 1000.0), new Product("Shoe", 49.99), new Product("Pencil", 0.5));

		for (Product item : cart){
			System.out.println(String.format("%s: %.2f", item.getDesc(), item.getValue()));
		}

		Stream<Product> stream = StreamSupport.stream(cart.spliterator(), false);
		Double sum = stream.reduce(0.0, (acc, prod) -> acc + prod.getValue(), Double::sum);

		System.out.println(String.format("Total: %.2f", sum));
	}
}
