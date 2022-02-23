package com.ates.readingisgood.service.customer;

import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto create(CustomerDto customerDto);

    List<Order> listCustomerOrders(Integer id);
}
