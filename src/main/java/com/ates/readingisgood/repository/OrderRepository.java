package com.ates.readingisgood.repository.order;

import com.ates.readingisgood.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>, JpaSpecificationExecutor<Order> {
	
	@Query(value="SELECT * FROM ORDER WHERE CUSTOMERID = :customerId", nativeQuery=true)
    List<Order> findByCustomeridEquals(@Param("customerId") Long customerId);

}
