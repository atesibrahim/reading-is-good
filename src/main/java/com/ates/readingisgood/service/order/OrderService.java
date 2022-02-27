package com.ates.readingisgood.service.order;

import com.ates.readingisgood.dto.OrderDto;
import com.ates.readingisgood.exception.DateException;
import com.ates.readingisgood.exception.RecordNotFoundException;
import com.ates.readingisgood.exception.SufficientException;

import java.util.Date;
import java.util.List;

public interface OrderService {

    OrderDto get(Integer id) throws RecordNotFoundException;

    OrderDto create(OrderDto orderDto) throws SufficientException, RecordNotFoundException;

    List<OrderDto> listOrdersByDateInterval(Date startDate, Date endDate, Integer pageNo, Integer pageSize) throws DateException;
}
