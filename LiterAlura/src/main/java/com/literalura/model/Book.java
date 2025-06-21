package com.literalura.model;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String language;
    private int downloadCount;
    private Integer authorBirthYear;
    private Integer authorDeathYear;


    public Book() {}

    public Book(String title, String author, String language, int downloadCount, Integer authorBirthYear, Integer authorDeathYear) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.downloadCount = downloadCount;
        this.authorBirthYear = authorBirthYear;
        this.authorDeathYear = authorDeathYear;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Integer getAuthorBirthYear() {
        return authorBirthYear;
    }

    public void setAuthorBirthYear(Integer authorBirthYear) {
        this.authorBirthYear = authorBirthYear;
    }

    public Integer getAuthorDeathYear() {
        return authorDeathYear;
    }

    public void setAuthorDeathYear(Integer authorDeathYear) {
        this.authorDeathYear = authorDeathYear;
    }

    @Override
    public String toString() {
        return "📖 Título: " + title + "\n" +
                "✍️ Autor: " + author + " (" + authorBirthYear + " - " +
                (authorDeathYear != null ? authorDeathYear : "vivo") + ")\n" +
                "🗣️ Idioma: " + language + "\n" +
                "⬇️ Descargas: " + downloadCount + "\n";
    }
}
