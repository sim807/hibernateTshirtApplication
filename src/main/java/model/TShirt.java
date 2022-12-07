package model;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table
public class TShirt {
	
	@Id
	private String id;
	private String name;
	private String color;
	private char gender;
	private char size;
	private float price;
	private float rating;
	private String availability;
	
	
	
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

	public void setGender(char c) {
		this.gender = c;
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
	
	
	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

}
