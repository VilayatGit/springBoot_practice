package com.springbootpractice.spring.controller;

import com.springbootpractice.spring.model.AuthorDTO;
import com.springbootpractice.spring.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    public static final String AUTHOR_PATH = "/api/v1/author";
    public static final String AUTHOR_PATH_ID = AUTHOR_PATH + "/{authorId}";

    private final AuthorService authorService;

    @GetMapping(AUTHOR_PATH)
    public Set<AuthorDTO> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping(AUTHOR_PATH_ID)
    public AuthorDTO getAuthorById(@PathVariable("authorId") Long id){
        return authorService.getAuthorById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping(AUTHOR_PATH)
    public ResponseEntity createNewAuthor(@RequestBody AuthorDTO authorDTO){
        authorService.createNewAuthor(authorDTO);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(AUTHOR_PATH_ID)
    public ResponseEntity updateAuthor(@PathVariable("authorId") Long id,@RequestBody AuthorDTO authorDTO){
        authorService.updateAuthor(id,authorDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(AUTHOR_PATH_ID)
    public ResponseEntity deleteAuthorById(@PathVariable("authorId") Long id){
        authorService.deleteAuthorById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
