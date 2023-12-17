package com.springbootpractice.spring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    @Version
    private Integer version;
    private String authorName;
    @OneToMany(mappedBy = "author")
    private Set<Book> books;
}
