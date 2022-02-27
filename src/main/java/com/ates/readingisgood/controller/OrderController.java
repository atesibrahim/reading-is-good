package com.ates.readingisgood.controller;

import com.ates.readingisgood.dto.OrderDto;
import com.ates.readingisgood.exception.DateException;
import com.ates.readingisgood.exception.RecordNotFoundException;
import com.ates.readingisgood.exception.SufficientException;
import com.ates.readingisgood.service.order.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("orders")
@Validated
@Tag(name = "Orders", description = "Orders API")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "Get Order By Id", description = "Get Order By Id", tags = { "Orders" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = OrderDto.class))) })
    @GetMapping(value = "/{id}")
    public OrderDto getById(@PathVariable(name = "id") @Positive Integer id) throws RecordNotFoundException {
        return orderService.get(id);
    }

    @Operation(summary = "List Order By Date", description = "List Order By Date", tags = { "Orders" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = OrderDto.class)))) })
    @GetMapping
    public List<OrderDto> listOrdersByDate(@RequestParam(name = "start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                           @RequestParam(name = "end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                           @RequestParam(name = "page_no") @PositiveOrZero Integer pageNo,
                                           @RequestParam(name = "page_size") @Positive Integer pageSize) throws DateException {
        return orderService.listOrdersByDateInterval(startDate, endDate, pageNo, pageSize);
    }

    @Operation(summary = "Create New Order", description = "Create New Order", tags = { "Orders" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = OrderDto.class))) })
    @PostMapping
    public OrderDto save(@RequestBody @Validated OrderDto orderDto) throws SufficientException, RecordNotFoundException {
        return orderService.create(orderDto);
    }
}