package com.ates.readingisgood.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BOOK")
@ToString
public class Book{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;

	@Column(name = "Price")
	private Double price;

	@Column(name = "Stock")
	private Integer stock;

}
