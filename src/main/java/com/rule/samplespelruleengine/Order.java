package com.rule.samplespelruleengine;

public class Order {

	private String type;

	private Item[] items;

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public float totalPrice() {
		float total = 0;
		for (Item item : items) {
			total = total + item.totalItemPrice();
		}
		return total;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
