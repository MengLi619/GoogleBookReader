package com.xiaoheifamily.bookstore.controller;

import com.xiaoheifamily.bookstore.model.Book;
import com.xiaoheifamily.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "book/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("book", new Book());
        return "book/edit";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Book book) {

        bookRepository.save(book);
        return "book/edit";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model) {

        model.addAttribute("book", bookRepository.findOne(id));
        return "book/edit";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
    public String edit(Book book) {

        bookRepository.saveAndFlush(book);
        return "book/edit";
    }
}
