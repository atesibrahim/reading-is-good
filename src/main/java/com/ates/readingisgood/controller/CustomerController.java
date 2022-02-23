package com.ates.readingisgood.controller;

import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.dto.CustomerDto;
import com.ates.readingisgood.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/{id}/orders")
    public List<Order> getCustomerOrders(@PathVariable(name = "id") Integer id){
        return customerService.listCustomerOrders(id);
    }

    @PostMapping
    public CustomerDto create(@RequestBody CustomerDto customerDto){
        return customerService.create(customerDto);
    }


}
