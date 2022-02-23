package com.ates.readingisgood.service.book;

import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.dto.BookDto;
import com.ates.readingisgood.dto.CustomerDto;

import java.util.List;

public interface BookService {

    BookDto create(BookDto bookDto);

    BookDto updateStock(Integer id, Integer stock);
}
