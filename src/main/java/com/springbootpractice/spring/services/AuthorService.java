package com.springbootpractice.spring.services;

import com.springbootpractice.spring.model.AuthorDTO;

import java.util.Optional;
import java.util.Set;

public interface AuthorService{

    Set<AuthorDTO> getAuthors();

    Optional<AuthorDTO> getAuthorById(Long id);

    AuthorDTO createNewAuthor(AuthorDTO authorDTO);

    Optional<AuthorDTO> updateAuthor(Long id,AuthorDTO authorDTO);

    Boolean deleteAuthorById(Long id);
}
