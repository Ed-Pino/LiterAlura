package com.literalura.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.literalura.model.Book;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class GutendexAPI {

    private static final String BASE_URL = "https://gutendex.com/books/?search=";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Optional<Book> buscarLibro(String titulo) {
        try {
            String url = BASE_URL + titulo.replace(" ", "%20");

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonNode root = mapper.readTree(response.body());
            JsonNode results = root.path("results");

            if (!results.isArray() || results.isEmpty()) {
                return Optional.empty();
            }

            JsonNode libroJson = results.get(0);
            String title = libroJson.path("title").asText();
            String language = libroJson.path("languages").get(0).asText().toUpperCase();
            int downloads = libroJson.path("download_count").asInt();

            JsonNode authors = libroJson.path("authors");

            String author = "Autor desconocido";
            Integer birthYear = null;
            Integer deathYear = null;

            if (authors.isArray() && authors.size() > 0) {
                JsonNode firstAuthor = authors.get(0);
                author = firstAuthor.path("name").asText();
                if (firstAuthor.has("birth_year") && !firstAuthor.get("birth_year").isNull()) {
                    birthYear = firstAuthor.get("birth_year").asInt();
                }
                if (firstAuthor.has("death_year") && !firstAuthor.get("death_year").isNull()) {
                    deathYear = firstAuthor.get("death_year").asInt();
                }
            }

            Book book = new Book(title, author, language, downloads, birthYear, deathYear);
            return Optional.of(book); // ✅ Retorno faltante

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al consultar la API: " + e.getMessage());
            return Optional.empty();
        }
    }

}
