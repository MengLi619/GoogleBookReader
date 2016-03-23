package com.xiaoheifamily.bookstore.service;

import com.xiaoheifamily.bookstore.dto.Volumes;
import com.xiaoheifamily.bookstore.model.Book;
import com.xiaoheifamily.bookstore.repository.BookRepository;
import com.xiaoheifamily.bookstore.webapi.GoogleBookApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final GoogleBookApi googleBookApi;

    @Autowired
    public BookService(BookRepository bookRepository, GoogleBookApi googleBookApi) {
        this.bookRepository = bookRepository;
        this.googleBookApi = googleBookApi;
    }

    public void importByQuery(String query) {

        try {
            createBooks(googleBookApi.getVolumes(query).execute().body())
                    .forEach(x -> {
                        if (!bookRepository.existsByGoogleBookId(x.getGoogleBookId())) {
                            bookRepository.save(x);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Book> createBooks(Volumes volumes) {

        return volumes.getItems().stream()
                .map(x -> {
                    Book book = new Book();
                    book.setGoogleBookId(x.getId());
                    book.setTitle(x.getVolumeInfo().getTitle());
                    book.setDescription(x.getDescription());
                    book.setImage(x.getImageLinks().getThumbnail());

                    return book;
                })
                .collect(Collectors.toList());
    }
}