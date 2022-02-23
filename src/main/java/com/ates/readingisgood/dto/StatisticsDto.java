package com.ates.readingisgood.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class StatisticsDto {
    private String month;
    private Integer totalOrderCount;
    private Integer totalBookCount;
    private Double totalPurchaseCount;
}
