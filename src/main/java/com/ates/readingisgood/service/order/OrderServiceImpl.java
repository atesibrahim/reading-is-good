package com.ates.readingisgood.service.order;

import com.ates.readingisgood.domain.Book;
import com.ates.readingisgood.domain.Customer;
import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.dto.OrderDto;
import com.ates.readingisgood.exception.DateException;
import com.ates.readingisgood.exception.RecordNotFoundException;
import com.ates.readingisgood.exception.SufficientException;
import com.ates.readingisgood.repository.BookRepository;
import com.ates.readingisgood.repository.CustomerRepository;
import com.ates.readingisgood.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    @Transactional
    public OrderDto get(Integer id) {
        log.info("Order get started. Coming data: . Order id :{}", id);
        Order order = orderRepository.getById(id);
        log.info("Order get finished. Result data: . Order :{}", order);
        return OrderDto.builder()
                .orderAmount(order.getOrderAmount())
                .customerId(order.getCustomerId())
                .bookId(order.getBookId())
                .bookCount(order.getBookCount())
                .orderDate(order.getOrderDate())
                .build();
    }

    @Override
    @Transactional
    public OrderDto create(OrderDto orderDto) throws SufficientException, RecordNotFoundException {
        log.info("Order crete started. Coming data: . OrderDto:{}", orderDto);
        Optional<Customer> customer = Optional.ofNullable(customerRepository.findById(orderDto.getCustomerId())
                .orElseThrow(() -> new RecordNotFoundException("No customer found")));
        if (customer.get().getBalance() < orderDto.getOrderAmount()) {
            log.warn("Customer balance is not sufficient. Order amount: {}, Customer balance :{}",
                    orderDto.getOrderAmount(), customer.get().getBalance());
            throw new SufficientException("Your balance is not sufficient");
        }

        Optional<Book> book = Optional.ofNullable(bookRepository.findById(orderDto.getBookId())
                .orElseThrow(() -> new RecordNotFoundException("No book found")));
        if (book.get().getStock() < orderDto.getBookCount()) {
            log.warn("There is no enough stock for this order. Order book count: {}, Book count :{}",
                    orderDto.getBookCount(), book.get().getStock());
            throw new SufficientException("The stock of books is not enough for your order");
        }

        Order order = Order.builder()
                .customerId(orderDto.getCustomerId())
                .orderAmount(orderDto.getOrderAmount())
                .bookCount(orderDto.getBookCount())
                .bookId(orderDto.getBookId()).build();
        Order result = orderRepository.save(order);

        log.info("Order create finished. response data. Order:{}", result);

        return OrderDto.builder()
                .orderAmount(result.getOrderAmount())
                .customerId(result.getCustomerId())
                .bookId(result.getBookId())
                .bookCount(result.getBookCount())
                .orderDate(result.getOrderDate())
                .build();
    }

    @Override
    public List<OrderDto> listOrdersByDateInterval(Date startDate, Date endDate) throws DateException {
        log.info("Order listOrdersByDateInterval started. Coming Start date:{}, End date:{}", startDate, endDate);
        if (startDate.after(endDate)){
            log.warn("Start date cannot be greater than end date");
            throw new DateException("StartDate Cannot Be Greater Than EndDate");
        }
        LocalDateTime localStartDate = startDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        LocalDateTime localEndDate = endDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        List<Order> orders = orderRepository.findByOrderDateIsBetween(localStartDate, localEndDate);

        List<OrderDto> resultOrders = new ArrayList<>();
        orders.forEach(order->
                resultOrders.add(OrderDto.builder()
                        .orderAmount(order.getOrderAmount())
                        .customerId(order.getCustomerId())
                        .bookId(order.getBookId())
                        .bookCount(order.getBookCount())
                         .orderDate(order.getOrderDate())
                        .build())
        );
        log.info("Order listOrdersByDateInterval finished. Response data size: {}", resultOrders.size());
        return resultOrders;
    }
}
