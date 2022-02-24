package com.ates.readingisgood.service;

import com.ates.readingisgood.domain.Customer;
import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.dto.OrderDto;
import com.ates.readingisgood.exception.DateException;
import com.ates.readingisgood.repository.CustomerRepository;
import com.ates.readingisgood.repository.OrderRepository;
import com.ates.readingisgood.service.order.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void it_should_list_orders_get_by_date() throws DateException {
        //Given
        Integer id = 1;
        Double price = 10.0;

        LocalDateTime date = LocalDateTime.now();
        Order order = Order.builder()
                .customerId(id).orderDate(date)
                .orderAmount(12.3).id(id).bookId(id).bookCount(5).build();
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        OrderDto orderDto = OrderDto.builder()
                .customerId(id).orderDate(date)
                .orderAmount(12.3).bookId(id).bookCount(5).build();

        Customer customer = Customer.builder().id(1).balance(price).build();

        LocalDateTime endDate = LocalDateTime.now();
        when(orderRepository.findByOrderDateIsBetween(date, endDate)).thenReturn(orderList);

        Date startDate = new Date();
        Date endDate2 = new Date();
        //When
        orderService.listOrdersByDateInterval(startDate, endDate2);

        //Then
        verifyNoInteractions(orderRepository);
    }

    @Test
    public void it_should_list_orders_end_date_could_not_smaller_than_start() {
        //Given

        Date startDate = new Date();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date endDate2 = new Date();
        //When
        try {
            orderService.listOrdersByDateInterval(endDate2, startDate);
        } catch (DateException d){
            assertEquals("StartDate Cannot Be Greater Than EndDate", d.getMessage());
        }

        //Then
        verifyNoInteractions(orderRepository);
    }

    @Test
    public void it_should_order_get_by_id() {
        //Given
        Integer id = 1;

        LocalDateTime date = LocalDateTime.now();

        Order order = Order.builder().id(id)
                .customerId(id).orderDate(date)
                .orderAmount(120.3).bookId(id).bookCount(5).build();

        when(orderRepository.getById(1)).thenReturn(order);

        //When
        orderService.get(id);

        //Then
        verifyNoInteractions(orderRepository);
    }
}
