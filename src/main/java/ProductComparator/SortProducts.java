package ProductComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Product;

public class SortProducts {
	
	public void sortByPrice(ArrayList<Product> products) {

		Collections.sort(products, new Comparator<Product>() {
			public int compare(Product o1, Product o2) {
				return (int) (o1.getPrice()-o2.getPrice());
				
			}
		});
	}
	
	public void sortByRating(ArrayList<Product> products) {
		Collections.sort(products, new Comparator<Product>() {
			public int compare(Product o1, Product o2) {
				return (int) (o2.getRating()-o1.getRating());
				
			}
		});
	}
}
