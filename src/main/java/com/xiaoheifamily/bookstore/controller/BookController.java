package com.xiaoheifamily.bookstore.controller;

import com.xiaoheifamily.bookstore.model.Book;
import com.xiaoheifamily.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> query(String query, int page, int size, HttpServletRequest request) {
        return bookService.query(query, page, size, request);
    }
}