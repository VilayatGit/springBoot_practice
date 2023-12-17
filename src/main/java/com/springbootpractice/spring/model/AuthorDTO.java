package com.springbootpractice.spring.model;

import com.springbootpractice.spring.entities.Book;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
@Builder
@Data
public class AuthorDTO {
    private Long authorId;
    private Integer version;
    private String authorName;
    private Set<Book> books;
}
