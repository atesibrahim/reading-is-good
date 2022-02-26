package com.ates.readingisgood.controller;

import com.ates.readingisgood.dto.StatisticsDto;
import com.ates.readingisgood.service.statistics.StatisticsService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("statistics")
@Validated
@Tag(name = "Statistics", description = "Statistics API")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @Operation(summary = "List Customer's Monthly Statistics", description = "List Customer's Monthly Statistics", tags = { "Statistics" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = StatisticsDto.class)))) })
    @GetMapping(value = "/{id}")
    public List<StatisticsDto> getCustomersMonthlyStatistics(@PathVariable(name = "id") @Positive Integer id) {
        return statisticsService.getCustomerMonthlyStatistics(id);
    }
}
