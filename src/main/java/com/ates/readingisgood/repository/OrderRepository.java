package com.ates.readingisgood.repository;

import com.ates.readingisgood.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	@Query(value="SELECT * FROM ORDERS WHERE ORDER_CUSTOMER_ID = :customerId", nativeQuery=true)
    List<Order> findByCustomerIdEquals(@Param("customerId") Integer customerId);

}
