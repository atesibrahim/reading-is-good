package com.ates.readingisgood.controller;

import com.ates.readingisgood.dto.StatisticsDto;
import com.ates.readingisgood.service.statistics.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping(value = "/{id}")
    public List<StatisticsDto> getCustomersMonthlyStatistics(@PathVariable(name = "id") Integer id) {
        return statisticsService.getCustomerMonthlyStatistics(id);
    }
}
