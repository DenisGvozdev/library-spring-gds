package ru.gds.spring.domain;

import java.util.Date;

public class Book {

    private int id;
    private String name;
    private Date createDate;
    private String description;
    private byte[] image;
    private Integer genre;
    private Integer status;
    private Integer author;

    public Book(String name, Date createDate,
                 String description, byte[] image,
                 Integer genre, Integer status, Integer author) {
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
