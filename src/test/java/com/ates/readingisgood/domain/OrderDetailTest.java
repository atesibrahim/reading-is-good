package com.ates.readingisgood.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderTest {

	private Order order;
	
	@BeforeEach
	public void init() {
		order = Order.builder().build();
	}

	@Test
	public void it_should_id_should_be_null() {
		assertNull(order.getId());
	}
	
	@Test
	public void it_should_customer_id_equal_by_given_customer_id() {
		order.setCustomerId(2);
		assertEquals(2, order.getCustomerId());
	}

	@Test
	public void it_should_book_id_equal_by_given_book_id() {
		order.setBookId(5);
		assertEquals(5, order.getBookId());
	}
	
	@Test
	public void it_should_book_count_equal_by_given_book_count() {
		order.setBookCount(150);
		assertEquals(150, order.getBookCount());
	}
	
	@Test
	public void it_should_order_amount_equal_by_order_amount() {
		order.setOrderAmount(1.500);
		assertEquals(1.500, order.getOrderAmount());
	}

	@Test
	public void it_should_order_count_equal_by_given() {
		order.setOrderCount(12);
		assertEquals(12, order.getOrderCount());
	}

	@Test
	public void it_should_local_date_equal_by_given() {
		LocalDateTime localDateTime = LocalDateTime.now();
		order.setOrderDate(localDateTime);
		assertEquals(localDateTime, order.getOrderDate());
	}

	@Test
	public void it_should_equal_to_string_by_given()
	{
		String expected = "Order(id=null, customerId=null, bookId=null, orderCount=null, bookCount=null, orderAmount=null, OrderDate=null)";
		assertEquals(expected, order.toString());
	}

	@Test
	public void it_should_true_all_arg_constructor(){
		order = new Order(null, null, null, null, null, null, null);
		assertNull(order.getOrderDate());
	}
}
