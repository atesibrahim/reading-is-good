package com.ates.readingisgood.controller;

import com.ates.readingisgood.dto.BookDto;
import com.ates.readingisgood.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PutMapping(value = "/{id}/stock")
    public BookDto updateStock(@PathVariable(name = "id") Integer id, Integer stock){
         return bookService.updateStock(id, stock);
    }

    @PostMapping
    public BookDto save(@RequestBody BookDto bookDto){
        return bookService.create(bookDto);
    }


}