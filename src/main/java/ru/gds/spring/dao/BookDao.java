package ru.gds.spring.dao;

import ru.gds.spring.domain.Book;

import java.util.List;

public interface BookDao {

    Book getById(int id);

    List<Book> getAll();
}
