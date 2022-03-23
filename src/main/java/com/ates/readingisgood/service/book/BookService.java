package com.ates.readingisgood.service.book;

import com.ates.readingisgood.dto.BookDto;
import com.ates.readingisgood.exception.RecordNotFoundException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface BookService {

    BookDto create(BookDto bookDto);

    BookDto updateStock(Integer id, Integer stock) throws RecordNotFoundException;

    void exportToExcel(HttpServletResponse response) throws IOException;
}
