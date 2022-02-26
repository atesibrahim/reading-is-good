package com.ates.readingisgood.domain;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;

	@Column(name = "Balance")
	private Double balance;

	@OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<>();
}
