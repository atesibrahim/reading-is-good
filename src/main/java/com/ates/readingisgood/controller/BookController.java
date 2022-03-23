package com.ates.readingisgood.controller;

import com.ates.readingisgood.dto.BookDto;
import com.ates.readingisgood.exception.RecordNotFoundException;
import com.ates.readingisgood.service.book.BookService;
import io.swagger.v3.oas.annotations.Operation;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.IOException;

@RestController
@RequestMapping("books")
@Validated
@Tag(name = "Book", description = "Book API")
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "Create New Book", description = "Create New Book", tags = {"Book"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = BookDto.class)))})
    @PostMapping
    public BookDto save(@RequestBody @Validated BookDto bookDto) {
        return bookService.create(bookDto);
    }

    @Operation(summary = "Update Book Stock", description = "Update Book Stock", tags = {"Book"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = BookDto.class)))})
    @PutMapping(value = "/{id}/stock")
    public BookDto updateStock(@PathVariable(name = "id") @Positive Integer id, @RequestParam @PositiveOrZero Integer stock) throws RecordNotFoundException {
        return bookService.updateStock(id, stock);
    }

    @Operation(summary = "Export Book List to Excel", description = "Export Book List to Exce", tags = {"Book"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")})
    @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) {
        try {
            bookService.exportToExcel(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}