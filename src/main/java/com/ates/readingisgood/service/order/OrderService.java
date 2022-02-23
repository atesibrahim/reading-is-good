package com.ates.readingisgood.service.order;

import com.ates.readingisgood.dto.OrderRequestDto;

import java.util.Date;
import java.util.List;

public interface OrderService {

    OrderRequestDto get(Integer id);

    OrderRequestDto create(OrderRequestDto orderDto);

    List<OrderRequestDto> listOrdersByDateInterval(Date startDate, Date endDate);
}
