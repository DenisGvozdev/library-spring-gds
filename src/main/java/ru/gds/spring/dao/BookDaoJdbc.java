package ru.gds.spring.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gds.spring.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class BookDaoJdbc implements BookDao {

    private final JdbcOperations jdbc;

    public BookDaoJdbc(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Book getById(int id) {
        return jdbc.queryForObject("SELECT * FROM BOOKS WHERE ID = ?", new Object[] {id}, new BookMapper());
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query("SELECT * FROM BOOKS", new BookMapper());
    }

    private static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");
            return new Book(id, name, null, null, null, null, null, null);
        }
    }
}
