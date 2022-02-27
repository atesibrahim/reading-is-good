package com.ates.readingisgood.service;

import com.ates.readingisgood.domain.Customer;
import com.ates.readingisgood.dto.CustomerDto;
import com.ates.readingisgood.repository.CustomerRepository;
import com.ates.readingisgood.service.customer.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void it_should_customer_save() {
        //Given
        Double price = 10.0;

        CustomerDto customerDto = CustomerDto.builder().id(1).balance(price).build();
        Customer customer = Customer.builder().id(1).balance(price).build();
        when(customerRepository.save(customer)).thenReturn(customer);

        //When
        customerService.create(customerDto);

        //Then
        verifyNoInteractions(customerRepository);
    }

    @Test
    public void it_should_return_list_customer_orders() {
        //Given
        Integer id = 2;
        Double price = 10.0;

        CustomerDto customerDto = CustomerDto.builder().id(1).balance(price).build();
        Customer customer = Customer.builder().id(1).balance(price).build();
        when(customerRepository.save(customer)).thenReturn(customer);

        //When
        assertEquals(4, customerService.listCustomerOrders(id, 0, 10).size());

        //Then
    }

    @Test
    public void it_should_return_empty_list_customer_orders() {
        //Given
        Integer id = 10;

        //When
        assertEquals(0, customerService.listCustomerOrders(id, 0, 10).size());

        //Then
        verifyNoInteractions(customerRepository);
    }
}
