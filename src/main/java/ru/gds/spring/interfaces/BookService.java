package ru.gds.spring.interfaces;

import ru.gds.spring.domain.Book;

public interface BookService {
    public String getBookById(String id);

    public void getAllBooks();

    public void addBook(String name);

    public void updateBook(Integer id, String name);

    public void removeBookById(String id);
}
