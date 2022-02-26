package com.ates.readingisgood.dto;


import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "Book", description = "Book Model")
public class BookDto {

	@Schema(description = "Unique identifier of the Book.", example = "1", required = true)
	@Positive
	private Integer id;

	@Schema(description = "Book Price.", example = "1.0", required = true)
	@NotNull
	@Positive
	private Double price;

	@Schema(description = "Book Stock.", example = "1", required = true)
	@NotNull
	@PositiveOrZero
	private Integer stock;
}
