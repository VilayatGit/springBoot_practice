package com.springbootpractice.spring.services;

import com.springbootpractice.spring.model.AuthorDTO;
import com.springbootpractice.spring.model.BookDTO;

import java.util.Optional;
import java.util.Set;

public interface BookService{

    Set<BookDTO> getBooks();

    Optional<BookDTO> getBookById(Long id);

    BookDTO createNewBook(BookDTO bookDTO);

    Optional<BookDTO> updateBook(Long id,BookDTO bookDTO);

    Boolean deleteBookById(Long id);
}
