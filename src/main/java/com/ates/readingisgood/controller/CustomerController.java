package com.ates.readingisgood.controller;

import com.ates.readingisgood.domain.Customer;
import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/{id}/orders")
    public List<Order> getCustomerOrders(@PathVariable Integer id){
        return customerService.listAllCustomerOrders(id);
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer){
        return customerService.create(customer);
    }


}
