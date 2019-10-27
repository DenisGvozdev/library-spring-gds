package ru.gds.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Service;
import ru.gds.spring.dao.JdbcBookRepository;
import ru.gds.spring.domain.Book;
import ru.gds.spring.interfaces.BookService;

import java.util.Date;
import java.util.List;

@ShellComponent
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    @Qualifier("jdbcBookRepository")
    private JdbcBookRepository bookRepository;

    @ShellMethod("add-book")
    public void addBook(String name) {
        Boolean result = bookRepository.insert(name, new Date(), "", null, 1, 1, 1);
        if (Boolean.TRUE.equals(result))
            System.out.println("book success inserted");
        else
            System.out.println("error");
    }

    @ShellMethod("get-all-books")
    public void getAllBooks() {
        List<Book> books = bookRepository.getAll();
        if (books == null || books.isEmpty())
            System.out.println("Not found data");
        else {
            for (Book book : books)
                printBook(book);
        }
    }

    @ShellMethod("get-book-by-id")
    public String getBookById(String id) {
        Book book = bookRepository.getById(Integer.valueOf(id));
        if (book == null)
            System.out.println("Not found data");
        else
            printBook(book);

        return book.getName();
    }

    @ShellMethod("remove-book-by-id")
    public void removeBookById(String id) {
        Boolean result = bookRepository.removeById(Integer.valueOf(id));
        if (Boolean.TRUE.equals(result))
            System.out.println("book success deleted");
        else
            System.out.println("error");
    }

    @ShellMethod("update-book")
    public void updateBook(Integer id, String name) {
        Boolean result = bookRepository.update(id, name, new Date(), "Описание", null, 2, 1, 2);
        if (Boolean.TRUE.equals(result))
            System.out.println("book success inserted");
        else
            System.out.println("error");
    }

    private void printBook(Book book) {
        System.out.println("Book id: " + book.getId() +
                " name: " + book.getName() +
                " createDate: " + book.getCreateDate() +
                " description: " + book.getDescription() +
                " image: " + book.getImage() +
                " genre: " + book.getGenre() +
                " status: " + book.getStatus() +
                " author: " + book.getAuthor()
        );
    }
}
