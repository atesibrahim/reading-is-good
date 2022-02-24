package com.ates.readingisgood.service.customer;

import com.ates.readingisgood.dto.CustomerDto;
import com.ates.readingisgood.dto.OrderDto;

import java.util.List;

public interface CustomerService {

    CustomerDto create(CustomerDto customerDto);

    List<OrderDto> listCustomerOrders(Integer id);
}
