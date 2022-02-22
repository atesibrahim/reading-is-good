package com.ates.readingisgood.dao.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "order")
public class Order{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "CustomerId")
	private Integer customerId;

	@Column(name = "BookId")
	private Integer bookId;

	@Column(name = "OrderCount")
	private Short orderCount;

	@Column(name = "BookCount")
	private Short bookCount;

	@Column(name = "OrderAmount")
	private Double orderAmount;

	@Column(name = "OrderDate")
	private LocalDateTime OrderDate;
}
