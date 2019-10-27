package ru.gds.spring.interfaces;

import ru.gds.spring.domain.Book;

import java.util.Date;
import java.util.List;

public interface BookRepository {

    Boolean insert(
            String name,
            Date createDate,
            String description,
            byte[] image,
            Integer genre,
            Integer status,
            Integer author);

    List<Book> getAll();

    Book getById(int id);

    Boolean removeById(int id);

    Boolean update(
            int id,
            String name,
            Date createDate,
            String description,
            byte[] image,
            Integer genre,
            Integer status,
            Integer author);
}
