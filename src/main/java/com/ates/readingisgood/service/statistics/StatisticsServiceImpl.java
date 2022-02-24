package com.ates.readingisgood.service.statistics;

import com.ates.readingisgood.dto.StatisticsDto;
import com.ates.readingisgood.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<StatisticsDto> getCustomerMonthlyStatistics(Integer customerId) {

        //TODO validate customerId

        List<Map<String, Object>> orderMonthlyStatistics = orderRepository.findMonthlyOrderStatistics(customerId);
        List<StatisticsDto> monthlyStatistics = new ArrayList<>();

        if (orderMonthlyStatistics.size() < 1) {
            return monthlyStatistics;
        }

        orderMonthlyStatistics.forEach(element -> {
            final StatisticsDto statisticsDto = StatisticsDto.builder()
                    .month(Month.of((Integer) element.get("month")).toString())
                    .totalOrderCount((BigInteger) element.get("totalOrderCount"))
                    .totalBookCount((BigInteger) element.get("totalBookCount"))
                    .totalPurchasedAmount((Double) element.get("totalPurchasedAmount")).build();
            monthlyStatistics.add(statisticsDto);
        });

        return monthlyStatistics;
    }
}
