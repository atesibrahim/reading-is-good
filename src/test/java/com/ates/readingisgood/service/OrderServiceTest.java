package com.ates.readingisgood.service;

import com.ates.readingisgood.dto.OrderDto;
import com.ates.readingisgood.exception.DateException;
import com.ates.readingisgood.exception.RecordNotFoundException;
import com.ates.readingisgood.exception.SufficientException;
import com.ates.readingisgood.repository.CustomerRepository;
import com.ates.readingisgood.service.order.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verifyNoInteractions;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void it_should_list_orders_get_by_date() throws DateException {
        //Given

        LocalDate startLocalDate = LocalDate.of(2022, 1, 1);
        Date startDate = Date.from(startLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Date endDate = new Date();
        //When
        assertEquals(4, orderService.listOrdersByDateInterval(startDate, endDate, 0, 4).size());

    }

    @Test
    public void it_should_empty_list_orders_get_by_date() throws DateException {
        //Given

        Date startDate = new Date();
        Date endDate2 = new Date();
        //When
        assertEquals(0, orderService.listOrdersByDateInterval(startDate, endDate2, 0, 4).size());

    }

    @Test
    public void it_should_list_orders_end_date_could_not_smaller_than_start() {
        //Given

        Date startDate = new Date();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date endDate2 = new Date();

        //When && Then
        try {
            orderService.listOrdersByDateInterval(endDate2, startDate, 0, 4);
        } catch (DateException d){
            assertEquals("StartDate Cannot Be Greater Than EndDate", d.getMessage());
        }
    }

    @Test
    public void it_should_order_get_by_id() throws RecordNotFoundException {
        //Given
        Integer id = 1;

        //When
        assertEquals(2,orderService.get(id).getCustomerId());
        assertEquals(1500.0,orderService.get(id).getOrderAmount());
    }

    @Test
    public void it_should_order_save() {
        //Given
        Integer id = 2;

        LocalDateTime date = LocalDateTime.now();
        OrderDto orderDto = OrderDto.builder()
                .customerId(id).orderDate(date)
                .orderAmount(12.3).bookId(id).bookCount(5).build();

        //When && Then
        try{
            orderService.create(orderDto);
        } catch (RecordNotFoundException | SufficientException e){
            assertEquals("Your balance is not sufficient", e.getMessage());
        }
    }

    @Test
    public void it_should_order_not_save_when_customer_not_found(){
        //Given
        Integer id = 5;
        LocalDateTime date = LocalDateTime.now();
        OrderDto orderDto = OrderDto.builder()
                .customerId(id).orderDate(date)
                .orderAmount(12.3).bookId(id).bookCount(5).build();

        //When
        try{
            orderService.create(orderDto);
        } catch (RecordNotFoundException | SufficientException e){
            assertEquals("No customer found", e.getMessage());
        }

        //Then
        verifyNoInteractions(customerRepository);
    }

    @Test
    public void it_should_order_not_save_when_book_not_found(){
        //Given
        Integer customerId = 4;
        Integer bookId = 10;
        LocalDateTime date = LocalDateTime.now();
        OrderDto orderDto = OrderDto.builder()
                .customerId(customerId).orderDate(date)
                .orderAmount(12.3).bookId(bookId).bookCount(5).build();

        //When
        try{
            orderService.create(orderDto);
        } catch (RecordNotFoundException | SufficientException e){
            assertEquals("No book found", e.getMessage());
        }

        //Then
        verifyNoInteractions(customerRepository);
    }

    @Test
    public void it_should_order_not_save_when_customer_balance_not_sufficient(){
        //Given
        Integer customerId = 2;
        Integer bookId = 1;
        LocalDateTime date = LocalDateTime.now();
        OrderDto orderDto = OrderDto.builder()
                .customerId(customerId).orderDate(date)
                .orderAmount(12000000.3).bookId(bookId).bookCount(5).build();

        //When
        try{
            orderService.create(orderDto);
        } catch (RecordNotFoundException | SufficientException e){
            assertEquals("Your balance is not sufficient", e.getMessage());
        }

        //Then
        verifyNoInteractions(customerRepository);
    }

    @Test
    public void it_should_order_not_save_when_book_count_not_sufficient(){
        //Given
        Integer customerId = 4;
        Integer bookId = 4;
        LocalDateTime date = LocalDateTime.now();
        OrderDto orderDto = OrderDto.builder()
                .customerId(customerId).orderDate(date)
                .orderAmount(120.3).bookId(bookId).bookCount(5000).build();

        //When
        try{
            orderService.create(orderDto);
        } catch (RecordNotFoundException | SufficientException e){
            assertEquals("The stock of books is not enough for your order", e.getMessage());
        }

        //Then
        verifyNoInteractions(customerRepository);
    }
}
