package com.sahan.jaxrsapp.model;

public class Car {
	
	private int id;
	private String model;
	private String brand;
	private int year;
	private String color;
	private String type;
	
	public Car() {
		super();
	}

	public Car(int id, String model, String brand, int year) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
