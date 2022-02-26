package com.ates.readingisgood.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class BookTest {

	private Book book;
	
	@BeforeEach
	public void init() {
		book = Book.builder().build();
	}
	
	@Test
	public void it_should_price_equal_by_given_price() {
		book.setPrice(2.500);
		assertEquals(2.500, book.getPrice());
	}
	
	@Test
	public void it_should_stock_count_equal_by_given_stock_count() {
		book.setStock(150);
		assertEquals(150, book.getStock());
	}
	
	@Test
	public void it_should_id_equal_by_given_id() {
		book.setId(3);
		assertEquals(3, book.getId());
	}

	@Test
	public void it_should_true_all_arg_constructor(){
		book = new Book(null, null, null);
		assertNull(book.getPrice());
	}
}
