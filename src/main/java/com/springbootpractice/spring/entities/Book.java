package com.springbootpractice.spring.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Version
    private Integer version;
    private String bookName;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;
}
