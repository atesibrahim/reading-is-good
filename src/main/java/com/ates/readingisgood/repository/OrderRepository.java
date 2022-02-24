package com.ates.readingisgood.repository;

import com.ates.readingisgood.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    @Query(value="SELECT o from Order o where o.OrderDate between :startDate and :endDate")
    List<Order> findByOrderDateIsBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query(value = "SELECT MONTH(order_date) as month, count(*) as totalOrderCount, sum(o.book_count) as totalBookCount, " +
            "sum(o.order_amount) as totalPurchasedAmount FROM ORDERS o where o.customer_id=:customerId GROUP BY MONTH(order_date)",
            nativeQuery = true)
    List<Map<String, Object>> findMonthlyOrderStatistics(@Param("customerId") Integer customerId);

}
