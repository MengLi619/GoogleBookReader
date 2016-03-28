package com.xiaoheifamily.googlebookreader.service;

import com.xiaoheifamily.googlebookreader.model.Book;
import com.xiaoheifamily.googlebookreader.webapi.GoogleBookApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookService {

    private final ImageService imageService;
    private final GoogleBookApi googleBookApi;

    @Autowired
    public BookService(ImageService imageService, GoogleBookApi googleBookApi) {

        this.imageService = imageService;
        this.googleBookApi = googleBookApi;
    }

    @Cacheable(value = "books", key = "'books:'+ #query + ':' + #page + ':' + #size")
    public List<Book> query(String query, int page, int size, HttpServletRequest request) {

        try {
            return googleBookApi.getVolumes(query, page, size).execute().body()
                    .getItems().stream()
                    .map(x -> {
                        Book book = new Book();
                        book.setId(x.getId());
                        book.setTitle(x.getVolumeInfo().getTitle());
                        book.setDescription(x.getVolumeInfo().getDescription());
                        book.setImage(imageService.saveImage(x.getVolumeInfo().getImageLinks().getThumbnail(),
                                book.getId(), request));

                        return book;
                    })
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}