package com.ates.bookordermanagement.dao.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.ates.bookordermanagement.dao.customer.CustomerRepository;
import com.ates.bookordermanagement.dao.customer.CustomerRepositoryImpl;
import com.ates.bookordermanagement.dao.model.CustomerEntity;
import com.ates.bookordermanagement.utils.DeleteException;


@SpringBootTest
public class CustomerRepositoryTest {

	@Mock
	private CustomerRepository customerRepository;
	
	private CustomerRepositoryImpl customerRepositoryImpl;
	
	private List<CustomerEntity> customerEntities = new ArrayList<>();
	
	private CustomerEntity customerEntity;
	
	private Optional<CustomerEntity> customerOptional;
	
	@BeforeEach
	public void init() {
		customerEntity = new CustomerEntity();
		customerEntity.setBalance(100L);
		customerEntity.setCustomerName("ibrahim ates");
		customerEntities.add(customerEntity);
		customerOptional = Optional.ofNullable(customerEntity);
		customerRepositoryImpl = new CustomerRepositoryImpl(customerRepository);
	}
	
	@Test
	public void whenCalledGetAllCustomer_thenReturnList() {
		
		when(customerRepository.findAll()).thenReturn(customerEntities);
		
		assertTrue(customerRepositoryImpl.getAllCustomers().size()>0);
		
		assertEquals("ibrahim ates",customerRepositoryImpl.getAllCustomers().get(0).getCustomerName());
	}
	
	@Test
	public void whenCalledGetCustomerById_thenReturn() {
		
		when(customerRepository.findById(1L)).thenReturn(customerOptional);
		
		assertEquals("ibrahim ates",customerRepositoryImpl.getCustomerInfo(1L).getCustomerName());
	}
	
	@Test
	public void whenCalledCreateCustomer_thenReturnTrue() {
		
		when(customerRepository.save(customerEntity)).thenReturn(customerEntity);
		
		assertEquals("ibrahim ates",customerRepositoryImpl.addCustomer(customerEntity).getCustomerName());
	}
	
	@Test
	public void whenCalledDeleteCustomerById_thenDoNothing() throws DeleteException {
				
		doNothing().when(customerRepository).deleteById(1L);	
		
		
		try {
			customerRepositoryImpl.deleteCustomer(1L);
		} catch (DeleteException e) {
			assertEquals("Delete exception occurred.",e.getMessage());

		}
				
		
	}
	
	@Test
	public void whenCalledDeleteCustomerById_thenThrowException() throws DeleteException {
		
		EmptyResultDataAccessException exception = new EmptyResultDataAccessException(String.format("No with id %s exists!", 1L), 1);
				
		doThrow(exception).when(customerRepository).deleteById(1L);	
		
		try {
			customerRepositoryImpl.deleteCustomer(1L);
		} catch (DeleteException e) {
			assertEquals("Delete exception occurred.",e.getMessage());

		}
				
		
	}
}
