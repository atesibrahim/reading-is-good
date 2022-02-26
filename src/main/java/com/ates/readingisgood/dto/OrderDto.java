package com.ates.readingisgood.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "Orders", description = "Orders Model")
public class OrderDto {

	@Schema(description = "Customer Id.", example = "1", required = true)
	@NotNull
	@Positive
	private Integer customerId;
	@Schema(description = "Book Id.", example = "1", required = true)
	@NotNull
	@Positive
	private Integer bookId;
	@Schema(description = "Order Amount.", example = "1.0", required = true)
	@NotNull
	@Positive
	private Double orderAmount;
	@Schema(description = "Book Count.", example = "1", required = true)
	@NotNull
	@Positive
	private Integer bookCount;
	@Schema(description = "Order Date.")
	private LocalDateTime orderDate;
}
