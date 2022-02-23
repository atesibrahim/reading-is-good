package com.ates.readingisgood.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderDto {
	private Integer customerId;
	private Integer bookId;
	private Double orderAmount;
	private Integer bookCount;
	private LocalDateTime orderDate;
}
