package com.ates.readingisgood.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDto {
	@Positive
	private Integer id;
	@NotNull
	@Positive
	private Double price;
	@NotNull
	@PositiveOrZero
	private Integer stock;
}
