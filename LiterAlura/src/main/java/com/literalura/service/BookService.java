package com.literalura.service;

import com.literalura.model.Book;
import com.literalura.repository.BookRepository;
import com.literalura.dto.AutorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Optional<Book> findByTitle(String title) {
        return repository.findByTitleIgnoreCase(title);
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public List<Book> findByLanguage(String language) {
        return repository.findByLanguageIgnoreCase(language);
    }

    public List<Book> findByAuthor(String author) {
        return repository.findByAuthorContainingIgnoreCase(author);
    }

    public List<Object[]> countBooksByLanguage() {
        return repository.countBooksByLanguage();
    }

    public List<AutorDTO> findUniqueAuthorsAliveInYear(int year) {
        return repository.findAuthorsAliveInYear(year)
                .stream()
                .map(book -> new AutorDTO(book.getAuthor(), book.getAuthorBirthYear(), book.getAuthorDeathYear()))
                .distinct()
                .collect(Collectors.toList());
    }
}
