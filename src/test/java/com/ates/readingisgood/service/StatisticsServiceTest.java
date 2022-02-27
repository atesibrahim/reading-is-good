package com.ates.readingisgood.service;

import com.ates.readingisgood.service.statistics.StatisticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StatisticsServiceTest {

    @Autowired
    private StatisticsService statisticsService;

    @Test
    public void it_should_list_orders_statistics(){
        //Given
        Integer id = 2;
        //When && Then
        assertEquals(2, statisticsService.getCustomerMonthlyStatistics(id, 0, 4).size());
    }

    @Test
    public void it_should_return_empty_list_orders_statistics(){
        //Given
        Integer id = 10;
        //When && Then
        assertEquals(0, statisticsService.getCustomerMonthlyStatistics(id, 0, 4).size());
    }


}
