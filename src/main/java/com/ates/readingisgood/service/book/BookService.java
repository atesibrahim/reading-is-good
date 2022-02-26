package com.ates.readingisgood.service.book;

import com.ates.readingisgood.dto.BookDto;
import com.ates.readingisgood.exception.RecordNotFoundException;

public interface BookService {

    BookDto create(BookDto bookDto);

    BookDto updateStock(Integer id, Integer stock) throws RecordNotFoundException;
}
