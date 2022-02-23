package com.ates.readingisgood.repository;

import com.ates.readingisgood.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void it_should_find_all() {
		// Given
		final Customer customer2 = Customer.builder().id(2).balance(10.0).build();
		final Customer customer3 = Customer.builder().id(3).balance(100.0).build();

		customerRepository.save(customer2);
		customerRepository.save(customer3);
		// When
		final List<Customer> customerList = customerRepository.findAll();

		// Then
		assertEquals(2, customerList.get(0).getId());
		assertEquals(10.0, customerList.get(0).getBalance());
	}

	@Test
	public void it_should_be_saved() {
		// When
		final Customer customer = Customer.builder().id(5).balance(520.0).build();

		Customer customerResult = customerRepository.save(customer);

		// Then
		assertEquals(520.0, customerResult.getBalance());
	}

	@Test
	public void it_should_be_deleted() {
		// Given
		final Customer customer = Customer.builder().balance(500.0).build();

		customerRepository.save(customer);

		// When
		customerRepository.deleteById(1);

		// Then
	}
}
