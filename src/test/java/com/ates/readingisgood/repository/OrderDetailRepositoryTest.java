package com.ates.readingisgood.repository;

import com.ates.readingisgood.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderRepositoryTest {

	@Mock
	private OrderRepository orderRepository;
	
	@BeforeEach
	public void init() {}

	@Test
	public void it_should_find_by_id() {
		// Given
		final Order order = Order.builder().id(1).orderAmount(12.34).bookCount(3).build();

		// When
		when(orderRepository.findById(any())).thenReturn(Optional.ofNullable(order));

		// Then
		assertEquals(1, order.getId());
		assertEquals(12.34, order.getOrderAmount());
		assertEquals(3, order.getBookCount());
	}

	@Test
	public void it_should_find_by_customer_id() {
		// Given
		final Order order = Order.builder().id(1).orderAmount(12.34).bookCount(3).build();

		final List<Order> orderList = new ArrayList<>();
		orderList.add(order);

		// When
		when(orderRepository.findByCustomerIdEquals(any())).thenReturn(orderList);

		// Then
		assertEquals(1, orderList.get(0).getId());
		assertEquals(12.34, orderList.get(0).getOrderAmount());
		assertEquals(3, orderList.get(0).getBookCount());
	}
	
}
