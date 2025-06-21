package com.literalura.dto;
import java.util.List;

public record BookDTO(
        String title,
        List<AutorDTO> authors,
        String language,
        int download_count)
{}
