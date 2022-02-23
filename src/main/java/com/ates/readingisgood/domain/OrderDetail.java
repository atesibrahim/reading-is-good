package com.ates.readingisgood.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "ORDER_DETAILS")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @JoinColumn(name = "OrderDetailOrderId", foreignKey = @ForeignKey(name = "FK_ORDER_DETAIL_ORDER"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @Column(name = "OrderBookId")
    private Integer bookId;

    @Column(name = "BookCount")
    private Integer bookCount;

    @Column(name = "OrderAmount")
    private Double orderAmount;

    @Column(name = "OrderDate")
    private LocalDateTime OrderDate;

}
