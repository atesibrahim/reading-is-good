package com.ates.readingisgood.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@Schema(name = "Customer", description = "Customer Model")
public class CustomerDto {

	@Schema(description = "Unique identifier of the Customer.", example = "1", required = true)
	@Positive
	private Integer id;

	@Schema(description = "Customer's Balance.", example = "1.0", required = true)
	@NotNull
	@PositiveOrZero
	private Double balance;
	private List<OrderDto> orders;
}
