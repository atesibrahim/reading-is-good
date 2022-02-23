package com.ates.readingisgood.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class OrderDetailTest {

	private OrderDetail orderDetail;
	
	@BeforeEach
	public void init() {
		orderDetail = OrderDetail.builder().build();
	}

	@Test
	public void it_should_id_should_be_null() {
		assertNull(orderDetail.getId());
	}


	@Test
	public void it_should_book_id_equal_by_given_book_id() {
		orderDetail.setBookId(5);
		assertEquals(5, orderDetail.getBookId());
	}
	
	@Test
	public void it_should_book_count_equal_by_given_book_count() {
		orderDetail.setBookCount(150);
		assertEquals(150, orderDetail.getBookCount());
	}
	
	@Test
	public void it_should_order_amount_equal_by_order_amount() {
		orderDetail.setOrderAmount(1.500);
		assertEquals(1.500, orderDetail.getOrderAmount());
	}

	@Test
	public void it_should_order_count_equal_by_given() {
		orderDetail.setBookCount(12);
		assertEquals(12, orderDetail.getBookCount());
	}

	@Test
	public void it_should_local_date_equal_by_given() {
		LocalDateTime localDateTime = LocalDateTime.now();
		orderDetail.setOrderDate(localDateTime);
		assertEquals(localDateTime, orderDetail.getOrderDate());
	}

	@Test
	public void it_should_equal_to_string_by_given()
	{
		String expected = "OrderDetail(id=null, orderId=null, bookId=null, bookCount=null, orderAmount=null, OrderDate=null)";
		assertEquals(expected, orderDetail.toString());
	}

	@Test
	public void it_should_true_all_arg_constructor(){
		orderDetail = new OrderDetail(null, null, null, null, null, null);
		assertNull(orderDetail.getOrderDate());
	}
}
