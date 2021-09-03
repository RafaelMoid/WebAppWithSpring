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

        Publisher publisher = new Publisher();
        publisher.setName("MoidSan");
        publisher.setCity("Recife");
        publisher.setState("Pernambuco");


        Author rafael = new Author("Rafael", "Varela");
        Book hireMe = new Book("Hire me", "1235451");
        rafael.getBooks().add(hireMe);
        hireMe.getAuthors().add(rafael);

        hireMe.setPublisher(publisher);
        publisher.getBooks().add(hireMe);

        authorRepository.save(rafael);
        bookRepository.save(hireMe);
        publisherRepository.save(publisher);

        Author rafaelRibeiro = new Author("Rafael", "Ribeiro");
        Book contrataEu = new Book("Contrata EU", "738763847");
        rafaelRibeiro.getBooks().add(contrataEu);
        contrataEu.getAuthors().add(rafaelRibeiro);
        contrataEu.setPublisher(publisher);
        publisher.getBooks().add(contrataEu);

        authorRepository.save(rafaelRibeiro);
        bookRepository.save(contrataEu);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books:" + bookRepository.count());
        System.out.println("Number of publishers:" + publisher.getBooks().size());

    }
}
