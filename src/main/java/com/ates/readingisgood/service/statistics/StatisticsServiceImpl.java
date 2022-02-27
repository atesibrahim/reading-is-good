package com.ates.readingisgood.service.statistics;

import com.ates.readingisgood.dto.StatisticsDto;
import com.ates.readingisgood.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<StatisticsDto> getCustomerMonthlyStatistics(Integer customerId, Integer pageNo, Integer pageSize) {
        log.info("StatisticsService getCustomerMonthlyStatistics started. Coming customerId: {}, pageNo: {}, pageSize: {}", customerId, pageNo, pageSize);
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<Map<String, Object>> orderMonthlyStatistics = orderRepository.findMonthlyOrderStatistics(customerId, pageable);
        List<StatisticsDto> monthlyStatistics = new ArrayList<>();

        if (orderMonthlyStatistics.size() < 1) {
            log.info("StatisticsService no order found for statistics");
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
        log.info("StatisticsService getCustomerMonthlyStatistics finished. response size: {}", monthlyStatistics.size());
        return monthlyStatistics;
    }
}
