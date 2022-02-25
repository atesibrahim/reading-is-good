package com.ates.readingisgood.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class CustomerDto {
	@Positive
	private Integer id;
	@PositiveOrZero
	private Double balance;
	private List<OrderDto> orders;
}
