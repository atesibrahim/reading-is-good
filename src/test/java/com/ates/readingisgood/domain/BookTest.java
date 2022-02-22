package com.ates.readingisgood.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookEntityTest {

	
	private BookEntity bookEntity;
	
	@BeforeEach
	public void init() {
		bookEntity = new BookEntity();
	}
	
	@Test
	public void whenCalledGetBookName_thenCorrect() {
		bookEntity.setBookName("1984");
		assertEquals("1984", bookEntity.getBookName());
	}
	
	@Test
	public void whenCalledGetPrice_thenCorrect() {
		bookEntity.setPrice(2500L);
		assertEquals(2500L, bookEntity.getPrice());
	}
	
	@Test
	public void whenCalledGetCount_thenCorrect() {
		bookEntity.setCount(150);
		assertEquals(150, bookEntity.getCount());
	}
	
	@Test
	public void whenCalledGetId_thenCorrect() {
		bookEntity.setId(3L);
		assertEquals(3L, bookEntity.getId());
	}
}
