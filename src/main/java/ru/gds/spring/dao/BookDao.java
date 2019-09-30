package ru.gds.spring.dao;

import org.springframework.stereotype.Component;
import ru.gds.spring.domain.Book;

import java.util.Date;
import java.util.List;


public interface BookDao {

    Book getById(int id);

    List<Book> getAll();

    Boolean insert(
            String name,
            Date createDate,
            String description,
            byte[] image,
            Integer genre,
            Integer status,
            Integer author);

    Boolean removeById(int id);
}
