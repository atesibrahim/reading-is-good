package com.ates.readingisgood.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsDto {
    private String month;
    private BigInteger totalOrderCount;
    private BigInteger totalBookCount;
    private Double totalPurchasedAmount;
}
