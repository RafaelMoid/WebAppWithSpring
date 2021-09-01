package com.example.TDSSpringTest.repositories;

import com.example.TDSSpringTest.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
