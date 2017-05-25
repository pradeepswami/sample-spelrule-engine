package com.rule.samplespelruleengine;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class DiscountControllerTest {

	private DiscountController discountController;

	@Before
	public void setup() {
		discountController = new DiscountController();
		discountController.init();
	}

	@Test
	public void testGetDiscountWhenTypeIsInternet() throws Exception {

		Order order = new Order();
		order.setType("internet");
		order.setItems(new Item[] { new Item(), new Item(), new Item() });

		Float discount = discountController.getDiscount(order);

		assertThat(discount, equalTo(20.0F));
	}

	@Test
	public void testGetDiscountWhenTypeNotInternetMoreThan5item() throws Exception {

		Order order = new Order();
		order.setType("store");
		order.setItems(new Item[] { new Item(), new Item(), new Item(), new Item(), new Item() });

		Float discount = discountController.getDiscount(order);

		assertThat(discount, equalTo(15.0F));
	}

	@Test
	public void testGetDiscountWhenTypeNotInternetMoreThan1item() throws Exception {

		Order order = new Order();
		order.setType("store");
		order.setItems(new Item[] { new Item() });

		Float discount = discountController.getDiscount(order);

		assertThat(discount, equalTo(5.0F));
	}
}
