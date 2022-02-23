package com.ates.readingisgood.service.customer;

import com.ates.readingisgood.domain.Customer;
import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.dto.CustomerDto;
import com.ates.readingisgood.repository.CustomerRepository;
import com.ates.readingisgood.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;


    @Override
    public CustomerDto create(CustomerDto customerDto) {
        //TODO validate
        Customer customer = Customer.builder().balance(customerDto.getBalance()).build();
        Customer result = customerRepository.save(customer);

        customerDto = CustomerDto.builder().id(result.getId()).balance(result.getBalance()).build();

        return customerDto;
    }

    @Override
    public List<Order> listCustomerOrders(Integer id) {
        //TODO validate

        return customerRepository.findOrdersById(id);
    }
}
