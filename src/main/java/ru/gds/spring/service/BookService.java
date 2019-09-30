package ru.gds.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.gds.spring.dao.BookDao;
import ru.gds.spring.domain.Book;

import java.util.Date;
import java.util.List;

@ShellComponent
class BookService {

    @Autowired
    private ApplicationContext context;

    @ShellMethod("get-book-by-id")
    public void getBookById(String id) {
        BookDao bookDao = context.getBean(BookDao.class);
        Book book = bookDao.getById(Integer.valueOf(id));
        if (book == null)
            System.out.println("Not found data");
        else
            printBook(book);
    }

    @ShellMethod("get-all-books")
    public void getAllBooks() {
        BookDao bookDao = context.getBean(BookDao.class);
        List<Book> books = bookDao.getAll();
        if (books == null || books.isEmpty())
            System.out.println("Not found data");
        else {
            for (Book book : books)
                printBook(book);
        }
    }

    @ShellMethod("add-book")
    public void addBook(String name) {
        BookDao bookDao = context.getBean(BookDao.class);
        Boolean result = bookDao.insert(name, new Date(), "", null, 1, 1, 1);
        if (Boolean.TRUE.equals(result))
            System.out.println("book success inserted");
        else
            System.out.println("error");
    }

    @ShellMethod("remove-book-by-id")
    public void removeBookById(String id) {
        BookDao bookDao = context.getBean(BookDao.class);
        Boolean result = bookDao.removeById(Integer.valueOf(id));
        if (Boolean.TRUE.equals(result))
            System.out.println("book success deleted");
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
