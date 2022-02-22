package com.ates.bookordermanagement.dao.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.ates.bookordermanagement.dao.model.OrderEntity;
import com.ates.bookordermanagement.dao.order.OrderRepository;



@SpringBootTest
public class OrderRepositoryTest {

	@Mock
	private OrderRepository orderRepository;
	
	private List<OrderEntity> orderEntities = new ArrayList<>();
	
	private OrderEntity orderEntity;
	
	@BeforeEach
	public void init() {
		orderEntity = new OrderEntity();
		orderEntity.setBookCount(1);
		orderEntity.setBookId(3L);
		orderEntity.setCustomerId(1L);
		orderEntity.setOrderAmount(250L);
		orderEntities.add(orderEntity);
	}
	
	@Test
	public void whenCalledGetAllOrder_thenReturnList() {
		
		when(orderRepository.findByCustomeridEquals(any())).thenReturn(orderEntities);
		
		assertEquals(3,orderRepository.findByCustomeridEquals(1L).get(0).getBookId());
	}
	
}
