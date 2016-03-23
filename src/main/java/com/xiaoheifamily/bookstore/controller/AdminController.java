package com.xiaoheifamily.bookstore.controller;

import com.xiaoheifamily.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final BookService bookService;

    @Autowired
    public AdminController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "admin/index";
    }

    @RequestMapping(value = "import", method = RequestMethod.POST)
    public String importByQuery(String query, int startIndex, int maxResults) {

        bookService.importByQuery(query, startIndex, maxResults);
        return "redirect:/admin";
    }
}