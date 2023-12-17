package com.springbootpractice.spring.services;

import com.springbootpractice.spring.entities.Book;
import com.springbootpractice.spring.mappers.BookMapper;
import com.springbootpractice.spring.model.BookDTO;
import com.springbootpractice.spring.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Override
    public Set<BookDTO> getBooks() {
        return bookRepository.findAll().stream()
                .map((a) -> bookMapper.bookToBookDTO(a))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<BookDTO> getBookById(Long id) {
        return Optional.ofNullable(bookMapper.bookToBookDTO(bookRepository.findById(id).orElse(null)));
    }

    @Override
    public BookDTO createNewBook(BookDTO bookDTO) {
        return bookMapper.bookToBookDTO(bookRepository.save(bookMapper.bookDTOToBook(bookDTO)));
    }

    @Override
    public Optional<BookDTO> updateBook(Long id, BookDTO bookDTO) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()){
            Book existingBook = optionalBook.get();
            existingBook.setBookName(bookDTO.getBookName());
            existingBook.setAuthor(bookDTO.getAuthor());

            bookRepository.save(existingBook);
            Optional<BookDTO> updatedBookDTO = Optional.of(bookMapper.bookToBookDTO(existingBook));
            return updatedBookDTO;
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteBookById(Long id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}