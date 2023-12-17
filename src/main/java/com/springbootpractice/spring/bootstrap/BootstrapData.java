package com.springbootpractice.spring.bootstrap;

import com.springbootpractice.spring.entities.Author;
import com.springbootpractice.spring.entities.Book;
import com.springbootpractice.spring.repositories.AuthorRepository;
import com.springbootpractice.spring.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create Authors
        Author author1 = Author.builder()
                .authorName("John Doe")
                .build();

        Author author2 = Author.builder()
                .authorName("Jane Smith")
                .build();

        authorRepository.save(author1);
        authorRepository.save(author2);

        // Create Books
        Book book1 = Book.builder()
                .bookName("Spring in Action")
                .author(author1)
                .build();

        Book book2 = Book.builder()
                .bookName("Hibernate Basics")
                .author(author1)
                .build();

        Book book3 = Book.builder()
                .bookName("Java Fundamentals")
                .author(author2)
                .build();

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
    }
}
