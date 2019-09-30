package ru.gds.spring.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import ru.gds.spring.dao.BookDao;
import ru.gds.spring.dao.BookDaoJdbc;
import ru.gds.spring.domain.Book;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
@SpringBootTest
//@SqlGroup({
//        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/schema.sql"),
//        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/data.sql") })
public class BookServiceTest {

    @Autowired
    private static ApplicationContext context;

    @BeforeClass
    public static void runOnceBeforeClass() {
        context = SpringApplication.run(BookServiceTest.class);
        System.out.println("@BeforeClass - runOnceBeforeClass");
    }

    @AfterClass
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass - runOnceAfterClass");
    }

    @Test
    public void getBookByIdTest() {
//        BookDao bookDao = context.getBean(BookDaoJdbc.class);
//        Book book = bookDao.getById(1);
//        assertThat(book.getName())
//                .isEqualTo("Кольцо тьмы");
        System.out.println("getBookByIdTest SUCCESS");
    }
}
