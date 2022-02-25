package com.ates.readingisgood.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class OrderDto {
	@NotNull
	@Positive
	private Integer customerId;
	@NotNull
	@Positive
	private Integer bookId;
	@NotNull
	@Positive
	private Double orderAmount;
	@NotNull
	@Positive
	private Integer bookCount;
	private LocalDateTime orderDate;
}
