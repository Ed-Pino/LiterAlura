package com.literalura.controller;

import com.literalura.service.BookService;
import com.literalura.utils.GutendexAPI;


import java.util.Scanner;

public class BookController {

    private final BookService bookService;
    private final Scanner sc = new Scanner(System.in);

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n*** LiterAlura - Catálogo de Libros ***");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar libros registrados");
            System.out.println("3. Listar libros por idioma");
            System.out.println("4. Buscar libros por autor");
            System.out.println("5. Mostrar cantidad de libros por idioma");
            System.out.println("6. Listar autores vivos en un año específico");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> buscarLibro();
                case 2 -> listarLibros();
                case 3 -> listarPorIdioma();
                case 4 -> buscarPorAutor();
                case 5 -> contarLibrosPorIdioma();
                case 6 -> listarAutoresVivosPorAnio();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (option != 0);
    }

    private void buscarLibro() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = sc.nextLine();

        bookService.findByTitle(titulo).ifPresentOrElse(
                book -> System.out.println("El libro ya existe en la base de datos: " + book),
                () -> {
                    var bookOptional = new GutendexAPI().buscarLibro(titulo);
                    bookOptional.ifPresentOrElse(
                            libro -> {
                                bookService.save(libro);
                                System.out.println("Libro guardado: " + libro);
                            },
                            () -> System.out.println("Libro no encontrado en la API."));
                }
        );
    }

    private void listarLibros() {
        var libros = bookService.findAll();
        libros.forEach(System.out::println);
    }

    private void listarPorIdioma() {
        System.out.print("Ingrese el idioma (ES, EN, FR, PT): ");
        String idioma = sc.nextLine();
        var libros = bookService.findByLanguage(idioma);
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros en ese idioma.");
        } else {
            libros.forEach(System.out::println);
        }
    }

    private void buscarPorAutor() {
        System.out.print("Ingrese el nombre del autor: ");
        String autor = sc.nextLine();
        var libros = bookService.findByAuthor(autor);
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros del autor ingresado.");
        } else {
            libros.forEach(System.out::println);
        }
    }

    private void contarLibrosPorIdioma() {
        var conteo = bookService.countBooksByLanguage();
        if (conteo.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            System.out.println("Cantidad de libros por idioma:");
            conteo.forEach(obj -> {
                String idioma = (String) obj[0];
                Long cantidad = (Long) obj[1];
                System.out.printf("- %s: %d libros%n", idioma, cantidad);
            });
        }
    }

    private void listarAutoresVivosPorAnio() {
        System.out.print("Ingrese el año para buscar autores vivos: ");
        try {
            int year = Integer.parseInt(sc.nextLine());

            var autores = bookService.findUniqueAuthorsAliveInYear(year);
            if (autores.isEmpty()) {
                System.out.println("No se encontraron autores vivos en ese año.");
            } else {
                System.out.println("Autores vivos en el año " + year + ":");
                autores.forEach(autor -> System.out.printf("- ✍️ %s (%d - %s)\n",
                        autor.name(),
                        autor.birth_year(),
                        autor.death_year() != null ? autor.death_year() : "vivo"));
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un año válido.");
        }
    }





}