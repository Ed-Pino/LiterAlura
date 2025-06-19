package com.literalura.controller;

import com.literalura.model.Book;
import com.literalura.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> listarLibros() {
        return bookService.findAll();
    }

    // Otros endpoints...
}


