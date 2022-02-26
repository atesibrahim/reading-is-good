package com.ates.readingisgood.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
	public void it_should_local_date_equal_by_given() {
		LocalDateTime localDateTime = LocalDateTime.now();
		order.setOrderDate(localDateTime);
		assertEquals(localDateTime, order.getOrderDate());
	}

	@Test
	public void it_should_true_all_arg_constructor(){
		order = Order.builder().build();
		assertNull(order.getOrderDate());
	}
}
