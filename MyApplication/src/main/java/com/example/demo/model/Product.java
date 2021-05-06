package com.example.demo.model;

public class Product {
	private double price, discount, netPrice;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	public Product(double price, double discount, double netPrice) {
		super();
		this.price = price;
		this.discount = discount;
		this.netPrice = netPrice;
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", discount=" + discount + ", netPrice=" + netPrice + "]";
	}
}