package com.ates.readingisgood.service.statistics;

import com.ates.readingisgood.domain.Customer;
import com.ates.readingisgood.dto.StatisticsDto;
import com.ates.readingisgood.repository.BookRepository;
import com.ates.readingisgood.repository.CustomerRepository;
import com.ates.readingisgood.repository.OrderRepository;
import com.ates.readingisgood.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookRepository bookRepository;


    @Override
    public List<StatisticsDto> getCustomerMonthlyStatistics(Integer customerId) {

        Optional<Customer> customer = customerRepository.findById(customerId);

        if(!customer.isPresent()){
            //TODO log info will added here
            return null;
        }
        Date startDate = new Date();
        Date endDate = new Date();

        orderService.listOrdersByDateInterval(startDate, endDate);


        return null;
    }
}
