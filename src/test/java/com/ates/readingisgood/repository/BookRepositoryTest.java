package com.ates.readingisgood.repository;

import com.ates.readingisgood.domain.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;

	@BeforeEach
	public void init() {}

	@Test
	public void it_should_find_all() {
		// Given
		final Book book2 = Book.builder().id(2).stock(567).price(125.0).build();

		bookRepository.save(book2);
		// When
		final List<Book> bookList = bookRepository.findAll();

		// Then
		assertEquals(2, bookList.get(0).getId());
		assertEquals(567, bookList.get(0).getStock());
		assertEquals(125.0, bookList.get(0).getPrice());
		assertEquals(1, bookList.size());
	}

	@Test
	public void it_should_be_saved() {
		// Given
		final Book book = Book.builder().id(1).stock(10).price(5.0).build();

		// When
		Book bookResult = bookRepository.save(book);

		// Then
		assertEquals(10, bookResult.getStock());
		assertEquals(5.0, bookResult.getPrice());
	}

	@Test
	public void it_should_be_deleted() {
		// Given
		final Book book = Book.builder().id(1).stock(10).price(5.0).build();

		bookRepository.save(book);

		// When
		bookRepository.deleteById(1);

		// Then
	}

}
