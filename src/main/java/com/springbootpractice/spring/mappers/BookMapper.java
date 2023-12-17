package com.springbootpractice.spring.mappers;

import com.springbootpractice.spring.entities.Book;
import com.springbootpractice.spring.model.BookDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    public Book bookDTOToBook(BookDTO bookDTO);

    public BookDTO bookToBookDTO(Book book);
}
