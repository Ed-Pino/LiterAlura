package com.literalura.repository;

import com.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitleIgnoreCase(String title);
    List<Book> findByLanguageIgnoreCase(String language);
    List<Book> findByAuthorContainingIgnoreCase(String author);

    @Query("SELECT b FROM Book b WHERE b.authorBirthYear <= :year AND (b.authorDeathYear >= :year OR b.authorDeathYear IS NULL)")
    List<Book> findAuthorsAliveInYear(Integer year);

    @Query("SELECT b.language, COUNT(b) FROM Book b GROUP BY b.language")
    List<Object[]> countBooksByLanguage();
}
