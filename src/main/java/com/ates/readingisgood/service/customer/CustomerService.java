package com.ates.readingisgood.service.customer;

import com.ates.readingisgood.domain.Customer;
import com.ates.readingisgood.domain.Order;

import java.util.List;

public interface CustomerService {

    Customer create(Customer customer);

    List<Order> listAllCustomerOrders(Integer id);
}
