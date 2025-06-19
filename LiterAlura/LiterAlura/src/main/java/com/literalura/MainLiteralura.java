package com.literalura;

import com.literalura.controller.BookController;
import com.literalura.repository.BookRepository;
import com.literalura.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainLiteralura {

    public static void main(String[] args) {
        SpringApplication.run(MainLiteralura.class, args);
    }

    @Bean
    public CommandLineRunner run(BookRepository repository) {
        return args -> {
            BookService bookService = new BookService(repository);
            BookController controller = new BookController(bookService);
            //para consola
            //controller.showMenu(); // Lógica de consola
        };
    }
}

