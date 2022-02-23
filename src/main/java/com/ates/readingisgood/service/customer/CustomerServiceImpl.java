package com.ates.readingisgood.service.customer;

import com.ates.readingisgood.domain.Customer;
import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.domain.OrderDetail;
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
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Order> listAllCustomerOrders(Integer id) {

        return orderRepository.findByCustomerIdEquals(id);

    }
}
