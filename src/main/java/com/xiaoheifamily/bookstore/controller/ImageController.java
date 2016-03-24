package com.xiaoheifamily.bookstore.controller;

import com.xiaoheifamily.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping("/image")
public class ImageController {

    private final BookService bookService;

    @Autowired
    public ImageController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/{name}")
    @ResponseBody
    public ResponseEntity<byte[]> image(@PathVariable String name, HttpServletRequest request) throws IOException {

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(Files.readAllBytes(Paths.get(bookService.getImagePath(name))),
                headers, HttpStatus.OK);
    }
}
