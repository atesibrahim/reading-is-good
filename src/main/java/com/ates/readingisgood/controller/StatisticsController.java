package com.ates.readingisgood.controller;

import com.ates.readingisgood.dto.StatisticsDto;
import com.ates.readingisgood.service.statistics.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("statistics")
@Validated
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping(value = "/{id}")
    public List<StatisticsDto> getCustomersMonthlyStatistics(@PathVariable(name = "id") @Positive Integer id) {
        return statisticsService.getCustomerMonthlyStatistics(id);
    }
}
