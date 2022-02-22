package com.ates.readingisgood.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerEntityTest {

	
	private CustomerEntity customerEntity;
	
	@BeforeEach
	public void init() {
		customerEntity = new CustomerEntity();
	}
	
	@Test
	public void whenCalledConstructor_thenCorrect() {
		Set<OrderEntity> orders = new HashSet<>();
		customerEntity = new CustomerEntity("ibrahim ates", 150L, orders);

		assertEquals(null, customerEntity.getId());
	}
	
	@Test
	public void whenCalledEquals_thenCorrect() {
		assertEquals(true, customerEntity.equals(customerEntity));
	}
	
	@Test
	public void whenCalledEqualsNull_thenFalse() {
		assertEquals(false, customerEntity.equals(null));
	}
	
	@Test
	public void whenCalledHashcode_thenTrue() {
		assertEquals(31, customerEntity.hashCode());
	}
	
	
	@Test
	public void whenCalledGetId_thenCorrect() {
		assertEquals(null, customerEntity.getId());
	}
	
	@Test
	public void whenCalledGetCustomerName_thenCorrect() {
		customerEntity.setCustomerName("Ibrahim Ates");
		assertEquals("Ibrahim Ates", customerEntity.getCustomerName());
	}
	
	@Test
	public void whenCalledGetBalance_thenCorrect() {
		customerEntity.setBalance(2500L);
		assertEquals(2500L, customerEntity.getBalance());
	}
	
	@Test
	public void whenCalledGetOrders_thenTrue() {
		Set<OrderEntity> orderEntities = new HashSet<>();
		assertEquals(orderEntities, customerEntity.getOrders());
	}
	
	@Test
	public void whenCalledSetOrders_thenTrue() {
		Set<OrderEntity> orderEntities = new HashSet<>();
		customerEntity.setOrders(orderEntities);
		assertEquals(orderEntities, customerEntity.getOrders());
	}
}
