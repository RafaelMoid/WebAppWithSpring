package com.example.TDSSpringTest.repositories;

import com.example.TDSSpringTest.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
