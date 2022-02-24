package com.ates.readingisgood.controller;

import com.ates.readingisgood.dto.BookDto;
import com.ates.readingisgood.exception.RecordNotFoundException;
import com.ates.readingisgood.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping("books")
@Validated
public class BookController {

    @Autowired
    private BookService bookService;

    @PutMapping(value = "/{id}/stock")
    public BookDto updateStock(@PathVariable(name = "id")  @Positive Integer id, @RequestParam @PositiveOrZero Integer stock) throws RecordNotFoundException {
         return bookService.updateStock(id, stock);
    }

    @PostMapping
    public BookDto save(@RequestBody @Validated BookDto bookDto) {
        return bookService.create(bookDto);
    }
}