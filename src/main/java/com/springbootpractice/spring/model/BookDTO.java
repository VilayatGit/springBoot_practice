package com.springbootpractice.spring.model;

import com.springbootpractice.spring.entities.Author;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookDTO {
    private Long bookId;
    private Integer version;
    private String bookName;
    private Author author;
}
