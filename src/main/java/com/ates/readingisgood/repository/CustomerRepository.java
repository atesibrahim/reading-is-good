package com.ates.readingisgood.repository;

import com.ates.readingisgood.domain.Customer;
import com.ates.readingisgood.domain.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value="SELECT customer.orders from Customer customer where customer.id=:id")
    List<Order> findOrdersById(@Param("id") Integer id, Pageable pageable);
}
