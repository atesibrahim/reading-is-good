package com.ates.readingisgood.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
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
	private LocalDateTime orderDate;
}
