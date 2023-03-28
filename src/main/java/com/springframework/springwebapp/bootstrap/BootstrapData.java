package com.springframework.springwebapp.bootstrap;

import com.springframework.springwebapp.domain.Author;
import com.springframework.springwebapp.domain.Book;
import com.springframework.springwebapp.domain.Publisher;
import com.springframework.springwebapp.repositories.AuthorRepository;
import com.springframework.springwebapp.repositories.BookRepository;
import com.springframework.springwebapp.repositories.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    @Override
    public void run(String... args) throws Exception {
        Author authorMartin = new Author();
        authorMartin.setFirstName("Martin");
        authorMartin.setLastName("Fowler");

        Book bookRefactoring = new Book();
        bookRefactoring.setTitle("Refactoring");
        bookRefactoring.setIsbn("123");

        Author authorKent = new Author();
        authorKent.setFirstName("Kent");
        authorKent.setLastName("Beck");

        Book bookTdd = new Book();
        bookTdd.setTitle("TDD");
        bookTdd.setIsbn("321");

        authorMartin.getBooks().add(bookRefactoring);
        bookRefactoring.getAuthors().add(authorMartin);
        authorKent.getBooks().add(bookTdd);
        bookTdd.getAuthors().add(authorKent);

        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisher.setAddress("123 A");

        bookRefactoring.setPublisher(publisher);
        bookTdd.setPublisher(publisher);

        publisherRepository.save(publisher);
        authorRepository.save(authorMartin);
        authorRepository.save(authorKent);
        bookRepository.save(bookRefactoring);
        bookRepository.save(bookTdd);

        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
