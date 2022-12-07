package com.nagarro;

import java.util.ArrayList;

import model.Product;

public class Display {
	public void displayProducts(ArrayList<Product> products) {
		if(products.isEmpty()) {
			System.out.println("No T-Shirts Available");
		}
		for(Product product: products ) {
			System.out.println(product.toString());   
			
		}
		
	}

}
