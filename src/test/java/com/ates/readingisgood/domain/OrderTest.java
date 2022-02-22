package com.ates.readingisgood.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderEntityTest {

	
	private OrderEntity orderEntity;
	
	@BeforeEach
	public void init() {
		orderEntity = new OrderEntity();
	}
	
	@Test
	public void whenCalledEquals_thenCorrect() {
		assertEquals(true, orderEntity.equals(orderEntity));
	}
	
	@Test
	public void whenCalledEqualsNull_thenFalse() {
		assertEquals(false, orderEntity.equals(null));
	}
	
	@Test
	public void whenCalledHashcode_thenTrue() {
		assertEquals(31, orderEntity.hashCode());
	}
	
	@Test
	public void whenCalledGetId_thenCorrect() {
		assertEquals(null, orderEntity.getId());
	}
	
	@Test
	public void whenCalledGetCustomerId_thenCorrect() {
		orderEntity.setCustomerId(2L);
		assertEquals(2L, orderEntity.getCustomerId());
	}
	
	
	@Test
	public void whenCalledGetBookId_thenCorrect() {
		orderEntity.setBookId(5L);
		assertEquals(5L, orderEntity.getBookId());
	}
	
	@Test
	public void whenCalledGetBookCount_thenCorrect() {
		orderEntity.setBookCount(150);
		assertEquals(150, orderEntity.getBookCount());
	}
	
	@Test
	public void whenCalledGetOrderAmount_thenCorrect() {
		orderEntity.setOrderAmount(150L);
		assertEquals(150L, orderEntity.getOrderAmount());
	}
}
