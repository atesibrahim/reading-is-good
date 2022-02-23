package com.ates.readingisgood.service.statistics;

import com.ates.readingisgood.dto.StatisticsDto;

import java.util.List;

public interface StatisticsService {

    List<StatisticsDto> getCustomerMonthlyStatistics(Integer customerId);
}
