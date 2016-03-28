package com.xiaoheifamily.googlebookreader.controller;

import com.xiaoheifamily.googlebookreader.model.Book;
import com.xiaoheifamily.googlebookreader.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Book> query(@RequestParam String query,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int size,
                            HttpServletRequest request) {

        return bookService.query(query, page, size, request);
    }
}