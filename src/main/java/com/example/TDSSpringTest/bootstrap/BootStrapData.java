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
        rafael.getBooks().add(hireMe);
        hireMe.getAuthors().add(rafael);

        authorRepository.save(rafael);
        bookRepository.save(hireMe);

        Author rafaelRibeiro = new Author("Rafael", "Ribeiro");
        Book contrataEu = new Book("Contrata EU", "738763847");
        rafaelRibeiro.getBooks().add(contrataEu);
        contrataEu.getAuthors().add(rafaelRibeiro);

        authorRepository.save(rafaelRibeiro);
        bookRepository.save(contrataEu);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books:" + bookRepository.count());

    }
}
