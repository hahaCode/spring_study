package com.fan.ssmdemo.mapper;

import com.fan.ssmdemo.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    int addBook(Book book);

    int deleteBookById(@Param("bookID") int id);

    int updateBook(Book book);

    Book findBookById(@Param("bookID")int id);

    List<Book> findAllBooks();

    Book findBookByName(@Param("bookName") String bookName);
}
