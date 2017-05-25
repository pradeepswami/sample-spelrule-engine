package com.rule.samplespelruleengine;

public class Item {

	private String name;
	private float price;
	private int count = 1;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public float totalItemPrice() {
		return price * count;
	}

}
