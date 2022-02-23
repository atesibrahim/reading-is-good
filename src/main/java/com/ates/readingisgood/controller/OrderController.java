package com.ates.readingisgood.controller;

import com.ates.readingisgood.dto.OrderDto;
import com.ates.readingisgood.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDto> listOrdersByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Date endDate){
        return orderService.listOrdersByDateInterval(startDate, endDate);
    }

    @GetMapping(value = "/{id}")
    public OrderDto getById(@PathVariable(name = "id") Integer id){
        return orderService.get(id);
    }

    @PostMapping
    public OrderDto save(@RequestBody OrderDto orderDto){
        return orderService.create(orderDto);
    }


}