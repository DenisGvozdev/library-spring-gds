package ru.gds.spring.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.gds.spring.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
@Component
public class BookDaoJdbc implements BookDao {

    private final JdbcOperations jdbc;

    public BookDaoJdbc(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Book getById(int id) {
        return jdbc.queryForObject("SELECT * FROM BOOKS WHERE ID = ?", new Object[]{id}, new BookMapper());
    }

    @Override
    public Boolean insert(String name, Date createDate,
                          String description, byte[] image,
                          Integer genre, Integer status, Integer author) {
        jdbc.update("INSERT INTO BOOKS (`NAME`, CREATE_DATE, DESCRIPTION, `IMAGE`, GENRE, STATUS, AUTHOR)" +
                "VALUES (?,?,?,?,?,?,?)", name, createDate, description, image, genre, status, author);
        return true;
    }


    @Override
    public List<Book> getAll() {
        return jdbc.query("SELECT * FROM BOOKS", new BookMapper());
    }

    @Override
    public Boolean removeById(int id) {
        jdbc.update("DELETE FROM BOOKS WHERE ID = ?", id);
        return true;
    }

    private static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");
            Date createDate = resultSet.getDate("CREATE_DATE");
            String description = resultSet.getString("DESCRIPTION");
            byte[] image = resultSet.getBytes("IMAGE");
            Integer genre = resultSet.getInt("GENRE");
            Integer status = resultSet.getInt("STATUS");
            Integer author = resultSet.getInt("AUTHOR");
            return new Book(id, name, createDate, description, image, genre, status, author);
        }
    }
}
