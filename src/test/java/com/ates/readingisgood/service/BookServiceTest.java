package com.ates.readingisgood.service;

import com.ates.readingisgood.domain.Book;
import com.ates.readingisgood.dto.BookDto;
import com.ates.readingisgood.exception.RecordNotFoundException;
import com.ates.readingisgood.repository.BookRepository;
import com.ates.readingisgood.service.book.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void it_should_book_save() {
        //Given
        Double price = 10.0;
        Integer stock = 31;

        BookDto bookDto = BookDto.builder().id(1).price(price).stock(stock).build();
        Book book = Book.builder().id(1).price(price).stock(stock).build();
        when(bookRepository.save(book)).thenReturn(book);

        //When
        bookService.create(bookDto);

        //Then
        verifyNoInteractions(bookRepository);
    }

    @Test
    public void it_should_book_update_stock(){
        //Given
        Double price = 10.0;
        Integer stock = 31;
        Integer id = 1;

        BookDto bookDto = BookDto.builder().price(price).id(id).stock(stock).build();
        Book book = Book.builder().id(1).price(price).stock(stock).build();
        when(bookRepository.save(book)).thenReturn(book);

        //When
        try {
            bookService.updateStock(id, stock);
        } catch (RecordNotFoundException r)
        {
            assertEquals("There is No Book Record on Database with id: 1", r.getMessage());
        }

        //Then
        verifyNoInteractions(bookRepository);
    }
}
