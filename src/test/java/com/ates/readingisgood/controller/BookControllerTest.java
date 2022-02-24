package com.ates.readingisgood.controller;

import com.ates.readingisgood.dto.BookDto;
import com.ates.readingisgood.service.book.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {BookController.class, AuthController.class})
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private AuthController authController;

    private ObjectMapper objectMapper = new ObjectMapper();

    private String token;

    private BookDto bookDto;

    @Captor
    private ArgumentCaptor<BookDto> bookDtoArgumentCaptor;

    @BeforeEach
    public void it_should_return_token() throws Exception {

        mockMvc.perform(get("/token")
                .contentType(MediaType.APPLICATION_JSON));
        //Then
        token = authController.getToken();
    }

    @Test
    public void it_should_update_stock() throws Exception {
        //Given & //When
        Integer id = 1;
        Integer stock = 2;
        bookDto = BookDto.builder().id(id).stock(stock).price(12.3).build();
        when(bookService.updateStock(id, stock)).thenReturn(bookDto);

        final ResultActions resultActions =
                mockMvc.perform(put("/books/{id}/stock", id)
                        .header("Authorization", token)
                        .param("stock", stock.toString())
                        .contentType(MediaType.APPLICATION_JSON));
        //Then
        verify(bookService).updateStock(id, stock);
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void it_should_not_update_stock_without_token() throws Exception {
        //Given & //When
        Integer id = 1;
        Integer stock = 2;
        bookDto = BookDto.builder().id(id).stock(stock).price(12.3).build();
        when(bookService.updateStock(id, stock)).thenReturn(bookDto);

        final ResultActions resultActions =
                mockMvc.perform(put("/books/{id}/stock", id)
                        .param("stock", stock.toString())
                        .contentType(MediaType.APPLICATION_JSON));
        //Then
        verifyNoInteractions(bookService);
        resultActions.andExpect(status().is4xxClientError());
    }

    @Test
    public void it_should_not_update_stock_when_id_not_valid() throws Exception {
        //Given & //When
        Integer id = 0;
        Integer stock = 2;
        bookDto = BookDto.builder().id(id).stock(stock).price(12.3).build();
        when(bookService.updateStock(id, stock)).thenReturn(bookDto);

        try {
            final ResultActions resultActions =
                    mockMvc.perform(put("/books/{id}/stock", id)
                            .header("Authorization", token)
                            .param("stock", stock.toString())
                            .contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            assertEquals("updateStock.id: must be greater than 0", e.getCause().getMessage());
        }
        //Then
        verifyNoInteractions(bookService);
    }

    @Test
    public void it_should_not_update_stock_when_stock_not_valid() throws Exception {
        //Given & //When
        Integer id = 1;
        Integer stock = -1;
        bookDto = BookDto.builder().id(id).stock(stock).price(12.3).build();
        when(bookService.updateStock(id, stock)).thenReturn(bookDto);

        try {
            final ResultActions resultActions =
                    mockMvc.perform(put("/books/{id}/stock", id)
                            .header("Authorization", token)
                            .param("stock", stock.toString())
                            .contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            assertEquals("updateStock.stock: must be greater than or equal to 0", e.getCause().getMessage());
        }
        //Then
        verifyNoInteractions(bookService);
    }

    @Test
    public void it_should_save_customer() throws Exception {
        //Given & //When
        Integer id = 1;
        Double price = 2.0;
        BookDto bookDto = BookDto.builder().id(id).price(price).build();
        when(bookService.create(bookDto)).thenReturn(bookDto);

        final ResultActions resultActions =
                mockMvc.perform(post("/books")
                        .header("Authorization", token)
                        .content(objectMapper.writeValueAsString(bookDto))
                        .contentType(MediaType.APPLICATION_JSON));
        //Then
        verify(bookService).create(bookDtoArgumentCaptor.capture());
        resultActions.andExpect(status().isOk());
    }
}