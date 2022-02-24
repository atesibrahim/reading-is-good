package com.ates.readingisgood.controller;

import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.dto.CustomerDto;
import com.ates.readingisgood.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("customers")
@Validated
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/{id}/orders")
    public List<Order> getCustomerOrders(@PathVariable(name = "id")  @Positive Integer id){
        return customerService.listCustomerOrders(id);
    }

    @PostMapping
    public CustomerDto create(@RequestBody @Validated CustomerDto customerDto){
        return customerService.create(customerDto);
    }
}
