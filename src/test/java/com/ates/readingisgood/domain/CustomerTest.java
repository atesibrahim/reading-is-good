package com.ates.readingisgood.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class CustomerTest {

	private Customer customer;
	
	@BeforeEach
	public void init() {
		customer = Customer.builder().build();
	}

	@Test
	public void it_should_id_equal_by_given_id() {
		customer.setId(2);
		assertEquals(2, customer.getId());
	}
	
	@Test
	public void it_should_balance_equal_by_given_balance() {
		customer.setBalance(2.500);
		assertEquals(2.500, customer.getBalance());
	}

	@Test
	public void it_should_equal_to_string_by_given()
	{
		String expected = "Customer(id=null, balance=null)";
		assertEquals(expected, customer.toString());
	}

	@Test
	public void it_should_true_all_arg_constructor(){
		customer = new Customer(null, null, new ArrayList<>());
		assertNull(customer.getBalance());
	}

}
