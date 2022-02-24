package com.ates.readingisgood.service.order;

import com.ates.readingisgood.domain.Book;
import com.ates.readingisgood.domain.Customer;
import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.dto.OrderDto;
import com.ates.readingisgood.exception.DateException;
import com.ates.readingisgood.exception.SufficientException;
import com.ates.readingisgood.repository.BookRepository;
import com.ates.readingisgood.repository.CustomerRepository;
import com.ates.readingisgood.repository.OrderRepository;
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
        Order order = orderRepository.getById(id);
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
    public OrderDto create(OrderDto orderDto) throws SufficientException {
        Optional<Customer> customer = customerRepository.findById(orderDto.getCustomerId());
        if (customer.get().getBalance()<orderDto.getOrderAmount()) {
            throw new SufficientException("Your balance is not sufficient");
        }

        Optional<Book> book = bookRepository.findById(orderDto.getBookId());
        if (book.get().getStock() < orderDto.getBookCount()) {
            throw new SufficientException("The stock of books is not enough for your order");
        }

        Order order = Order.builder()
                .customerId(orderDto.getCustomerId())
                .orderAmount(orderDto.getOrderAmount())
                .bookCount(orderDto.getBookCount())
                .bookId(orderDto.getBookId()).build();
        Order result = orderRepository.save(order);

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
        if (startDate.after(endDate)){
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
        return resultOrders;
    }
}
