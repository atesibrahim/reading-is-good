package com.ates.readingisgood.controller;

import com.ates.readingisgood.dto.CustomerDto;
import com.ates.readingisgood.dto.OrderDto;
import com.ates.readingisgood.service.customer.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;

@RestController
@RequestMapping("customers")
@Validated
@Tag(name = "Customer", description = "Customer API")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Operation(summary = "List Customer Orders", description = "List Customer Orders", tags = { "Customer" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = OrderDto.class)))) })
    @GetMapping(value = "/{id}/orders")
    public List<OrderDto> getCustomerOrders(@PathVariable(name = "id")  @Positive Integer id,
                                            @RequestParam(name = "page_no") @PositiveOrZero Integer pageNo,
                                            @RequestParam(name = "page_size") @Positive Integer pageSize){
        return customerService.listCustomerOrders(id, pageNo, pageSize);
    }

    @Operation(summary = "Create New Customer", description = "Create New Customer", tags = { "Customer" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = CustomerDto.class))) })
    @PostMapping
    public CustomerDto create(@RequestBody @Validated CustomerDto customerDto){
        return customerService.create(customerDto);
    }
}
