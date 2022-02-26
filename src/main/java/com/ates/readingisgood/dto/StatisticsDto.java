package com.ates.readingisgood.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "Statistics", description = "Statistics Model")
public class StatisticsDto {
    @Schema(description = "Month", example = "May")
    private String month;
    @Schema(description = "Total Order Count", example = "1")
    private BigInteger totalOrderCount;
    @Schema(description = "Total Book Count", example = "1")
    private BigInteger totalBookCount;
    @Schema(description = "Total Purchased Amount", example = "1.0")
    private Double totalPurchasedAmount;
}
