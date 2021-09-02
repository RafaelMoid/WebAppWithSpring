package com.example.TDSSpringTest.bootstrap;

import com.example.TDSSpringTest.domain.Author;
import com.example.TDSSpringTest.domain.Book;
import com.example.TDSSpringTest.domain.Publisher;
import com.example.TDSSpringTest.repositories.AuthorRepository;
import com.example.TDSSpringTest.repositories.BookRepository;
import com.example.TDSSpringTest.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("MoidSan");
        publisher.setCity("Recife");
        publisher.setState("Pernambuco");

        publisherRepository.save(publisher);

        System.out.println("Publisher count:" + publisherRepository.count());


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

        System.out.println("Number of books:" + bookRepository.count());

    }
}
