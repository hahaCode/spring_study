package com.fan.ssmdemo.test;

import com.fan.ssmdemo.domain.Book;
import com.fan.ssmdemo.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean(BookService.class);
        List<Book> bookList = bookService.findAllBooks();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
