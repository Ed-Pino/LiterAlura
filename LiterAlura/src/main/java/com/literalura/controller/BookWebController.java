package com.literalura.controller;

import com.literalura.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookWebController {

    private final BookService bookService;

    public BookWebController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/libros")
    public String mostrarLibros(Model model) {
        model.addAttribute("libros", bookService.findAll());
        return "libros";
    }
}
