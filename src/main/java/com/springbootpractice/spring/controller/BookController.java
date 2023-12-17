package com.springbootpractice.spring.controller;

import com.springbootpractice.spring.model.BookDTO;
import com.springbootpractice.spring.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class BookController {

    public static final String BOOK_PATH = "/api/v1/book";
    public static final String BOOK_PATH_ID = BOOK_PATH + "/{bookId}";

    private final BookService bookService;

    @GetMapping(BOOK_PATH)
    public Set<BookDTO> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping(BOOK_PATH_ID)
    public BookDTO getBookById(@PathVariable("bookId") Long id){
        return bookService.getBookById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping(BOOK_PATH)
    public ResponseEntity createNewBook(@RequestBody BookDTO bookDTO){
        bookService.createNewBook(bookDTO);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(BOOK_PATH_ID)
    public ResponseEntity updateBook(@PathVariable("bookId") Long id,@RequestBody BookDTO bookDTO){
        bookService.updateBook(id,bookDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(BOOK_PATH_ID)
    public ResponseEntity deleteBookById(@PathVariable("bookId") Long id){
        bookService.deleteBookById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
