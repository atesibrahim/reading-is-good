package com.ates.bookordermanagement.dao.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.ates.bookordermanagement.dao.book.BookRepository;
import com.ates.bookordermanagement.dao.book.BookRepositoryImpl;
import com.ates.bookordermanagement.dao.model.BookEntity;
import com.ates.bookordermanagement.utils.DeleteException;


@SpringBootTest
public class BookRepositoryTest {

	@Mock
	private BookRepository bookRepository;
	
	private BookRepositoryImpl bookRepositoryImpl;
	
	private List<BookEntity> bookEntities = new ArrayList<>();
	
	private BookEntity bookEntity;
	
	@BeforeEach
	public void init() {
		bookEntity = new BookEntity();
		bookEntity.setPrice(100L);
		bookEntity.setBookName("1984");
		bookEntity.setId(1L);
		bookEntity.setCount(25);
		bookEntities.add(bookEntity);
		bookRepositoryImpl = new BookRepositoryImpl(bookRepository);
	}
	
	@Test
	public void whenCalledGetAllBook_thenReturnList() {
		
		when(bookRepository.findAll()).thenReturn(bookEntities);
		
		assertTrue(bookRepositoryImpl.getAllBooks().size()>0);
		
		assertEquals("1984",bookRepositoryImpl.getAllBooks().get(0).getBookName());
	}
	
	@Test
	public void whenCalledGetBookById_thenReturn() {
		
		when(bookRepository.getById(1L)).thenReturn(bookEntity);
		
		assertEquals("1984",bookRepositoryImpl.getBookInfo(bookEntity.getId()).getBookName());
	}
	
	@Test
	public void whenCalledCreateBook_thenReturnTrue() {
		
		when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
		
		assertEquals("1984",bookRepositoryImpl.addBook(bookEntity).getBookName());
	}
	
	@Test
	public void whenCalledDeleteBookById_thenDoNothing() throws DeleteException {
				
		doNothing().when(bookRepository).deleteById(1L);	
		
		
		try {
			bookRepositoryImpl.deleteBook(1L);
		} catch (DeleteException e) {
			assertEquals("Delete exception occurred.",e.getMessage());

		}
				
		
	}
	
	@Test
	public void whenCalledDeleteBookById_thenThrowException() throws DeleteException {
		
		EmptyResultDataAccessException exception = new EmptyResultDataAccessException(String.format("No with id %s exists!", 1L), 1);
				
		doThrow(exception).when(bookRepository).deleteById(1L);	
		
		try {
			bookRepositoryImpl.deleteBook(1L);
		} catch (DeleteException e) {
			assertEquals("Delete exception occurred.",e.getMessage());

		}
				
		
	}
}
