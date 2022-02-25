package com.ates.readingisgood.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class OrderDto {
	@Positive
	private Integer customerId;
	@Positive
	private Integer bookId;
	@Positive
	private Double orderAmount;
	@Positive
	private Integer bookCount;
	private LocalDateTime orderDate;
}
