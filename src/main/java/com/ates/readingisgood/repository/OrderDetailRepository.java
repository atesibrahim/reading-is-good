package com.ates.readingisgood.repository;

import com.ates.readingisgood.domain.Order;
import com.ates.readingisgood.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
	
	@Query(value="SELECT * FROM ORDER_DETAIL WHERE BOOK_ID = :bookId", nativeQuery=true)
    List<OrderDetail> findByBookIdEquals(@Param("bookId") Integer bookId);

}
