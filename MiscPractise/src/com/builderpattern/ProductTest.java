package com.builderpattern;

public class ProductTest {

	public static void main(String[] args) {

		Product product = new Product.ProductBuilder("Apple mac book",1000.00)
				.setDescription("A high-performance laptop").setStock(14).build();

		System.out.println(product);
	}

}
