package com.ates.readingisgood.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/health")
@Tag(name = "Health", description = "Application Health Check API")
public class ApiHealthController {

    @Operation(summary = "Check Application Health", description = "Check Application Health", tags = { "Health" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation") })
    @GetMapping
    public String healtCheck(){
        return "Service is running...";
    }
}
