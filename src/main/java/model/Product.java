package model;

//@SuppressWarnings("rawtypes")
public class Product {
	private String id;
	private String name;
	private String color;
	private char gender;
	private char size;
	private float price;
	private float rating;
	
	
	// Product Model constructor
	public Product(String id, String name,String color,char gender,
						char size,float price,float rating) {
		
		this.id = id;
		this.name = name;
		this.color = color;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.rating=rating;
		
		
	}
	
	
	//getter and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", color=" + color + ", gender=" + gender + ", size="
				+ size + ", price=" + price + ", rating=" + rating + "]";
	}

}
