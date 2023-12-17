package com.springbootpractice.spring.services;

import com.springbootpractice.spring.entities.Author;
import com.springbootpractice.spring.mappers.AuthorMapper;
import com.springbootpractice.spring.model.AuthorDTO;
import com.springbootpractice.spring.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorMapper authorMapper;
    private final AuthorRepository authorRepository;

    @Override
    public Set<AuthorDTO> getAuthors() {
        return authorRepository.findAll().stream()
                .map((a) -> authorMapper.authorToAuthorDTO(a))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<AuthorDTO> getAuthorById(Long id) {
        return Optional.ofNullable(authorMapper.authorToAuthorDTO(authorRepository.findById(id).orElse(null)));
    }

    @Override
    public AuthorDTO createNewAuthor(AuthorDTO authorDTO) {
        return authorMapper.authorToAuthorDTO(authorRepository.save(authorMapper.authorDTOToAuthor(authorDTO)));
    }

    @Override
    public Optional<AuthorDTO> updateAuthor(Long id, AuthorDTO authorDTO) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if (optionalAuthor.isPresent()){
            Author existingAuthor = optionalAuthor.get();
            existingAuthor.setAuthorName(authorDTO.getAuthorName());
            existingAuthor.setBooks(authorDTO.getBooks());

            authorRepository.save(existingAuthor);
            Optional<AuthorDTO> updatedAuthorDTO = Optional.of(authorMapper.authorToAuthorDTO(existingAuthor));
            return updatedAuthorDTO;
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteAuthorById(Long id) {
        if(authorRepository.existsById(id)){
            authorRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
