package com.ates.readingisgood.service.book;

import com.ates.readingisgood.domain.Book;
import com.ates.readingisgood.dto.BookDto;
import com.ates.readingisgood.exception.RecordNotFoundException;
import com.ates.readingisgood.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    @Transactional
    public BookDto create(BookDto bookDto) {
        log.info("Book create started. Coming data: . bookDto:{}", bookDto);
        Book book = Book.builder().id(bookDto.getId()).stock(bookDto.getStock()).price(bookDto.getPrice()).build();
        Book result = bookRepository.save(book);
        bookDto = BookDto.builder().id(result.getId()).stock(result.getStock()).price(result.getPrice()).build();
        log.info("Book create finished. response data: . bookDto:{}", bookDto);
        return bookDto;
    }

    @Override
    @Transactional
    public BookDto updateStock(Integer id, Integer stock) throws RecordNotFoundException {
        log.info("Book update stock started. Coming data id: {}, stock: {} ", id, stock);
        Optional<Book> book = Optional.ofNullable(bookRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("There is No Book Record on Database with id: " + id)));
        book.get().setStock(stock);
        Book result = bookRepository.save(book.get());
        log.info("Book update stock finished. Response data of book: {} ", result);
        return BookDto.builder().id(result.getId()).stock(result.getStock()).price(result.getPrice()).build();
    }
}
