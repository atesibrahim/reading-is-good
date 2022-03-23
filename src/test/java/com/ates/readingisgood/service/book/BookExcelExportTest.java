package com.ates.readingisgood.service.book;

import com.ates.readingisgood.domain.Book;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;
import java.util.List;

class BookExcelExportTest {

    @InjectMocks
    private BookExcelExport bookExcelExport;

    @Test
    void export() throws IOException {
        bookExcelExport = new BookExcelExport();
        Book book = Book.builder().id(1).price(1.2).stock(10).build();
        List<Book> bookList = List.of(book);
        MockHttpServletResponse response = new MockHttpServletResponse();
        bookExcelExport.export(response, bookList);
    }
}