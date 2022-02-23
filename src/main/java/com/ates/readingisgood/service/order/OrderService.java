package com.ates.readingisgood.service.order;

import com.ates.readingisgood.dto.OrderDto;

import java.util.Date;
import java.util.List;

public interface OrderService {

    OrderDto get(Integer id);

    OrderDto create(OrderDto orderDto);

    List<OrderDto> listOrdersByDateInterval(Date startDate, Date endDate);
}
