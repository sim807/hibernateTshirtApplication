package ProductComparator;
import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

import model.Product;


public class ProductComparator implements Comparator<Product> {
	
	public int compare(Product o1, Product o2) {
        return new CompareToBuilder()
                .append(o1.getPrice(), o2.getPrice())
                .append(o1.getRating(), o2.getRating()).toComparison();
    }
}
