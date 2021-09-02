package com.example.TDSSpringTest.repositories;

import com.example.TDSSpringTest.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
