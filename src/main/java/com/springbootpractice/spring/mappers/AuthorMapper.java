package com.springbootpractice.spring.mappers;

import com.springbootpractice.spring.entities.Author;
import com.springbootpractice.spring.model.AuthorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    public Author authorDTOToAuthor(AuthorDTO authorDTO);

    public AuthorDTO authorToAuthorDTO(Author author);

}
