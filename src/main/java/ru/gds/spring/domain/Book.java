package ru.gds.spring.domain;

import java.util.Date;

public class Book {

    private final int id;
    private final String name;
    private final Date createDate;
    private final String description;
    private final byte[] image;
    private final Integer genre;
    private final Integer status;
    private final Integer author;

    public Book(int id, String name, Date createDate,
                String description, byte[] image,
                Integer genre, Integer status, Integer author) {
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

    public String getName() {
        return name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getImage() {
        return image;
    }

    public Integer getGenre() {
        return genre;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getAuthor() {
        return author;
    }
}
