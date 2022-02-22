package com.ates.readingisgood.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column
	private Double balance;

	/*
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,
		      cascade = {
		              CascadeType.ALL
		          })
	@JoinTable(name = "customer_orders", 
	joinColumns = {
			@JoinColumn(name = "CustomerId", unique = true, referencedColumnName = "CustomerId", nullable = false) },
	inverseJoinColumns = {
			@JoinColumn(name = "OrderId", unique = true, referencedColumnName = "OrderId", nullable = false) })
	private Set<OrderEntity> orders = new HashSet<>();
	*/
}
