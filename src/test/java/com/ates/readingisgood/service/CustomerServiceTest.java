package com.ates.readingisgood.service;

import com.ates.readingisgood.domain.Customer;
import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.dto.CustomerDto;
import com.ates.readingisgood.repository.CustomerRepository;
import com.ates.readingisgood.service.customer.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerServiceImpl customerService;

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
    public void it_should_list_customer_orders() {
        //Given
        Integer id = 1;
        LocalDateTime date = LocalDateTime.now();

        Order order = Order.builder()
                .customerId(id).orderDate(date)
                .orderAmount(12.3).id(id).bookId(id).bookCount(15).build();
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        when(customerRepository.findOrdersById(id)).thenReturn(orders);

        //When
        customerService.listCustomerOrders(id);

        //Then
        verifyNoInteractions(customerRepository);
    }
}
