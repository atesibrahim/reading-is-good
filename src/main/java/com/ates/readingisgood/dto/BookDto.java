package com.ates.readingisgood.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BookDto {
	@Positive
	private Integer id;
	@Positive
	private Double price;
	@PositiveOrZero
	private Integer stock;
}
