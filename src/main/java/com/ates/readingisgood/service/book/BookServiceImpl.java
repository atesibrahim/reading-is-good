package com.ates.readingisgood.service.book;

import com.ates.readingisgood.domain.Book;
import com.ates.readingisgood.dto.BookDto;
import com.ates.readingisgood.exception.RecordNotFoundException;
import com.ates.readingisgood.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    @Transactional
    public BookDto create(BookDto bookDto) {
        Book book = Book.builder().id(bookDto.getId()).stock(bookDto.getStock()).price(bookDto.getPrice()).build();
        Book result = bookRepository.save(book);
        bookDto = BookDto.builder().id(result.getId()).stock(result.getStock()).price(result.getPrice()).build();
        return bookDto;
    }

    @Override
    @Transactional
    public BookDto updateStock(Integer id, Integer stock) throws RecordNotFoundException {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new RecordNotFoundException(String.format("There is No Book Record on Database with id: %s", id));
        }

        book.get().setStock(stock);
        Book result = bookRepository.save(book.get());
        return BookDto.builder().id(result.getId()).stock(result.getStock()).price(result.getPrice()).build();
    }
}
