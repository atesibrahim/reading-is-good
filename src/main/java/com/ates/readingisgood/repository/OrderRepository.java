package com.ates.readingisgood.repository;

import com.ates.readingisgood.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	@Query(value="SELECT o from Order o where o.customerId=:customerId")
    List<Order> findByOrderCustomerIdEquals(@Param("customerId") Integer customerId);

    @Query(value="SELECT o from Order o where o.OrderDate between :startDate and :endDate")
    List<Order> findByOrderDateIsBetween(LocalDateTime startDate, LocalDateTime endDate);
}
