package ru.gds.spring;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.gds.spring.dao.BookDao;
import ru.gds.spring.domain.Book;

import java.sql.SQLException;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws SQLException {

        ApplicationContext context = SpringApplication.run(Main.class);

        BookDao bookDao = context.getBean(BookDao.class);

        Book book = bookDao.getById(1);

        System.out.println("Book id: " + book.getId() + " name: " + book.getName());

        Console.main(args);
    }
}
