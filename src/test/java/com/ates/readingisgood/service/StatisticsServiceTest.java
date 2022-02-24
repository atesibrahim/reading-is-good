package com.ates.readingisgood.service;

import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.exception.DateException;
import com.ates.readingisgood.repository.OrderRepository;
import com.ates.readingisgood.service.statistics.StatisticsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StatisticsServiceTest {

    @Autowired
    private StatisticsService statisticsService;

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void it_should_list_orders_statistics() throws DateException {
        //Given
        Integer id = 1;
        LocalDateTime date = LocalDateTime.now();
        Order order = Order.builder()
                .customerId(id).orderDate(date)
                .orderAmount(12.3).id(id).bookId(id).bookCount(5).build();
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);

        List<Map<String, Object>> statistics = new ArrayList<>();

        when(orderRepository.findMonthlyOrderStatistics(id)).thenReturn(statistics);
        //When
        statisticsService.getCustomerMonthlyStatistics(id);

        //Then
        verifyNoInteractions(orderRepository);
    }


}
