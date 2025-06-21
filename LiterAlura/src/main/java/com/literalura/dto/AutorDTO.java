package com.literalura.dto;

import com.literalura.model.Book;
import com.literalura.repository.BookRepository;
import com.literalura.dto.AutorDTO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record AutorDTO(
        String name,
        Integer birth_year,
        Integer death_year
) {}


