package com.ates.readingisgood.repository;

import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.domain.OrderDetail;
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
public class OrderDetailRepositoryTest {

	@Mock
	private OrderDetailRepository orderDetailRepository;
	
	@BeforeEach
	public void init() {}

	@Test
	public void it_should_find_by_id() {
		// Given
		final OrderDetail orderDetail = OrderDetail.builder().id(1).orderAmount(12.34).bookCount(3).build();

		// When
		when(orderDetailRepository.findById(any())).thenReturn(Optional.ofNullable(orderDetail));

		// Then
		assertEquals(1, orderDetail.getId());
		assertEquals(12.34, orderDetail.getOrderAmount());
		assertEquals(3, orderDetail.getBookCount());
	}

	@Test
	public void it_should_find_by_customer_id() {
		// Given
		final OrderDetail orderDetail = OrderDetail.builder().id(1).orderAmount(12.34).bookCount(3).build();

		final List<OrderDetail> orderDetails = new ArrayList<>();
		orderDetails.add(orderDetail);

		// When
		when(orderDetailRepository.findByBookIdEquals(any())).thenReturn(orderDetails);

		// Then
		assertEquals(1, orderDetails.get(0).getId());
		assertEquals(12.34, orderDetails.get(0).getOrderAmount());
		assertEquals(3, orderDetails.get(0).getBookCount());
	}
	
}
