package com.fan.ssmdemo.service;

import com.fan.ssmdemo.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    int addBook(Book book);

    int deleteBookById(int id);

    int updateBook(Book book);

    Book findBookById(int id);

    List<Book> findAllBooks();

    Book findBookByName(String bookName);
}
