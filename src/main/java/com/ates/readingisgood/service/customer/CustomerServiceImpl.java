package com.ates.readingisgood.service.customer;

import com.ates.readingisgood.domain.Customer;
import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.dto.CustomerDto;
import com.ates.readingisgood.dto.OrderDto;
import com.ates.readingisgood.repository.CustomerRepository;
import com.ates.readingisgood.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;


    @Override
    @Transactional
    public CustomerDto create(CustomerDto customerDto) {
        Customer customer = Customer.builder().balance(customerDto.getBalance()).build();
        Customer result = customerRepository.save(customer);
        return CustomerDto.builder().id(result.getId()).balance(result.getBalance()).build();
    }

    @Override
    public List<OrderDto> listCustomerOrders(Integer id) {
        List<Order> orders = customerRepository.findOrdersById(id);
        List<OrderDto> customerOrders = new ArrayList<>();
        if (orders.size() > 0) {
            orders.forEach(element -> {
                final OrderDto orderDto = OrderDto.builder()
                        .orderAmount(element.getOrderAmount())
                        .orderDate(element.getOrderDate())
                        .customerId(element.getCustomerId())
                        .bookCount(element.getBookCount())
                        .bookId(element.getBookId()).build();
                customerOrders.add(orderDto);
            });
        }
        return customerOrders;
    }
}
