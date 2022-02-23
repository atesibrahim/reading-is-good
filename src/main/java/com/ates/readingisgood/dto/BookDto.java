package com.ates.readingisgood.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BookDto {
	private Integer id;
	private Double price;
	private Integer stock;
}
