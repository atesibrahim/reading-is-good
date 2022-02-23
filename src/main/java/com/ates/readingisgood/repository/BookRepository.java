package com.ates.readingisgood.repository;

import com.ates.readingisgood.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer>{
}
