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
@ToString
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;

	@JoinColumn(name = "OrderCustomerId", foreignKey = @ForeignKey(name = "FK_ORDER_CUSTOMER"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;

	@Column(name = "OrderDate")
	@CreationTimestamp
	private LocalDateTime orderDate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrderDetailOrderId", referencedColumnName = "Id")
	private List<OrderDetail> orderDetails = new ArrayList<>();
}
