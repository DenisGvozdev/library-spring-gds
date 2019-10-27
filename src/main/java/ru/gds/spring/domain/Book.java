package ru.gds.spring.domain;

import java.util.Date;

public class Book {

    private int id;
    private String name;
    private Date createDate;
    private String description;
    private byte[] image;
    private Genre genre;
    private Status status;
    private Author author;

    public Book(String name, Date createDate,
                 String description, byte[] image,
                Genre genre, Status status, Author author) {
        this.name = name;
        this.createDate = createDate;
        this.description = description;
        this.image = image;
        this.genre = genre;
        this.status = status;
        this.author = author;
    }

    public Book(Integer id, String name, Date createDate,
                String description, byte[] image,
                Genre genre, Status status, Author author) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.description = description;
        this.image = image;
        this.genre = genre;
        this.status = status;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
