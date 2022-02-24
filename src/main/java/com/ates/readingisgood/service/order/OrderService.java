package com.ates.readingisgood.service.order;

import com.ates.readingisgood.dto.OrderDto;
import com.ates.readingisgood.exception.DateException;
import com.ates.readingisgood.exception.SufficientException;

import java.util.Date;
import java.util.List;

public interface OrderService {

    OrderDto get(Integer id);

    OrderDto create(OrderDto orderDto) throws SufficientException;

    List<OrderDto> listOrdersByDateInterval(Date startDate, Date endDate) throws DateException;
}
