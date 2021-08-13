package com.fan.ssmdemo.controller;

import com.fan.ssmdemo.domain.Book;
import com.fan.ssmdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/searchAll")
    public String searchAll(Model model) {
        List<Book> bookList = bookService.findAllBooks();
        model.addAttribute("bookList", bookList);
        return "bookLists";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Book book) {
        bookService.addBook(book);
        return "redirect:/book/searchAll";
    }

    @RequestMapping("/toUpdate/{bookID}")
    public String toUpdateBook(@PathVariable int bookID, Model model) {
        Book book = bookService.findBookById(bookID);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Book book) {
        bookService.updateBook(book);
        return "redirect:/book/searchAll";
    }

    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable int bookID) {
        bookService.deleteBookById(bookID);
        return "redirect:/book/searchAll";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryBook, Model model) {

        Book book = bookService.findBookByName(queryBook);
        //和findAll方法保持一致
        List<Book> bookList = new ArrayList<>();
        if(book == null) {
            bookList = bookService.findAllBooks();
            model.addAttribute("errorMsg", "未找到该书籍!已为您显示全部书籍!");
        } else {
            bookList.add(book);
        }

        model.addAttribute("bookList", bookList);
        return "bookLists";
    }
}
