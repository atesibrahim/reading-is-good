package com.ates.readingisgood.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
@EqualsAndHashCode
@ToString
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;

	@JoinColumn(name = "CustomerId", foreignKey = @ForeignKey(name = "FK_ORDER_CUSTOMER"))
	private Integer customerId;

	@JoinColumn(name = "BookId", foreignKey = @ForeignKey(name = "FK_ORDER_BOOK"))
	private Integer bookId;

	@Column(name = "BookCount")
	private Integer bookCount;

	@Column(name = "OrderAmount")
	private Double orderAmount;

	@Column(name = "OrderDate")
	@CreationTimestamp
	private LocalDateTime OrderDate;
}
