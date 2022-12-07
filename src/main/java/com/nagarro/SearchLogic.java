package com.nagarro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ProductComparator.ProductComparator;

import ProductComparator.SortProducts;
import db.ProductDao;
import model.*;

public class SearchLogic {
	Display display= new Display();
	ArrayList<Product> products= new ArrayList<Product>();
	String[] elements;
	
	void searchProduct(String color, char size, char gender){
		
		SessionFactory sessionFactory= ProductDao.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tn= session.beginTransaction();
		
		Query q= session.createQuery("From TShirt");
		
		@SuppressWarnings("unchecked")
		List<TShirt> tShrtList=q.list();
		
		for(TShirt tshrt:tShrtList) {
			if(tshrt.getColor().equalsIgnoreCase(color) && tshrt.getSize()==Character.toUpperCase(size) && tshrt.getGender()==Character.toUpperCase(gender) && tshrt.getAvailability().equals("Y")) {
				// calling the Product constructer
				Product product = new Product(tshrt.getId(),tshrt.getName(),tshrt.getColor(),tshrt.getGender(),
						tshrt.getSize(),tshrt.getPrice(),tshrt.getRating() );
				
//				// adding a product in product list
				products.add(product);
			}
		}
		tn.commit();
	}
	
	//method to sort the result w.r.t. different parameters
	public void sort(int outputPreference) {
		SortProducts sp= new SortProducts();
		
		if(outputPreference==1) {

			sp.sortByPrice(products);
			
			
		}else if(outputPreference==2) {
			System.out.println("i am getting rated");
			
			sp.sortByRating(products);
			
		}else if(outputPreference==3) {
			
			Collections.sort(products, new ProductComparator());
		
		}else{
			
			System.out.println("wrong choice");
			return;
		}
		display.displayProducts(products);
	}
}

 

