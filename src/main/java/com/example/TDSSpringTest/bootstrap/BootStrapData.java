package com.example.TDSSpringTest.bootstrap;

import com.example.TDSSpringTest.domain.Author;
import com.example.TDSSpringTest.domain.Book;
import com.example.TDSSpringTest.repositories.AuthorRepository;
import com.example.TDSSpringTest.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author rafael = new Author("Rafael", "Varela");
        Book hireMe = new Book("Hire me", "1235451");
        

    }
}
