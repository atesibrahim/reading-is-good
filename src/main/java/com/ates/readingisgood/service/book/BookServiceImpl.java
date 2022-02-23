package com.ates.readingisgood.service.book;

import com.ates.readingisgood.domain.Book;
import com.ates.readingisgood.dto.BookDto;
import com.ates.readingisgood.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public BookDto create(BookDto bookDto) {
        //TODO validate
        Book book = Book.builder().id(bookDto.getId()).stock(bookDto.getStock()).price(bookDto.getPrice()).build();
        Book result = bookRepository.save(book);
        bookDto = BookDto.builder().id(result.getId()).stock(result.getStock()).price(result.getPrice()).build();
        return bookDto;
    }

    @Override
    public BookDto updateStock(Integer id, Integer stock) {
        //TODO validate
        Optional<Book> book = bookRepository.findById(id);
        BookDto bookDto = BookDto.builder().build();
        if( book.isPresent()){
            book.get().setStock(stock);
            Book result =bookRepository.save(book.get());
            bookDto = BookDto.builder().id(result.getId()).stock(result.getStock()).price(result.getPrice()).build();
        }
        return bookDto;
    }
}
