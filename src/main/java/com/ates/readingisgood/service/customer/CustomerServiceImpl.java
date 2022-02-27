package com.ates.readingisgood.service.customer;

import com.ates.readingisgood.domain.Customer;
import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.dto.CustomerDto;
import com.ates.readingisgood.dto.OrderDto;
import com.ates.readingisgood.repository.CustomerRepository;
import com.ates.readingisgood.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;


    @Override
    @Transactional
    public CustomerDto create(CustomerDto customerDto) {
        log.info("Customer create started. Coming data: . Customerdto:{}", customerDto);
        Customer customer = Customer.builder().balance(customerDto.getBalance()).build();
        Customer result = customerRepository.save(customer);
        log.info("Customer create finished. result data: . Customer: {}", result);
        return CustomerDto.builder().id(result.getId()).balance(result.getBalance()).build();
    }

    @Override
    public List<OrderDto> listCustomerOrders(Integer id, Integer pageNo, Integer pageSize) {
        log.info("Customer listCustomerOrders started. Coming data: . Customer id :{}, pageNo: {}, pageSize: {}", id, pageNo, pageSize);
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<Order> orders = customerRepository.findOrdersById(id, pageable);
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
        log.info("Customer listCustomerOrders finished. Result size data :{}", customerOrders.size());
        return customerOrders;
    }
}
