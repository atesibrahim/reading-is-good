package com.ates.readingisgood.controller;

import com.ates.readingisgood.dto.OrderDto;
import com.ates.readingisgood.exception.DateException;
import com.ates.readingisgood.exception.SufficientException;
import com.ates.readingisgood.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("orders")
@Validated
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDto> listOrdersByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Date endDate) throws DateException {
        return orderService.listOrdersByDateInterval(startDate, endDate);
    }

    @GetMapping(value = "/{id}")
    public OrderDto getById(@PathVariable(name = "id") @Positive Integer id){
        return orderService.get(id);
    }

    @PostMapping
    public OrderDto save(@RequestBody @Validated OrderDto orderDto) throws SufficientException {
        return orderService.create(orderDto);
    }
}