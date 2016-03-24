package com.xiaoheifamily.bookstore.service;

import com.xiaoheifamily.bookstore.dto.Volumes;
import com.xiaoheifamily.bookstore.model.Book;
import com.xiaoheifamily.bookstore.repository.BookRepository;
import com.xiaoheifamily.bookstore.webapi.GoogleBookApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final GoogleBookApi googleBookApi;
    private final String storagePath;
    private final String relativePath;

    @Autowired
    public BookService(BookRepository bookRepository, GoogleBookApi googleBookApi,
                       @Value("${image.storagePath}") String storagePath,
                       @Value("${image.relativePath}") String relativePath) {

        this.bookRepository = bookRepository;
        this.googleBookApi = googleBookApi;
        this.storagePath = storagePath;
        this.relativePath = relativePath;
    }

    public void importByQuery(String query, int startIndex, int maxResults, HttpServletRequest request) {

        try {
            createBooks(googleBookApi.getVolumes(query, startIndex, maxResults).execute().body(), request)
                    .forEach(x -> {
                        if (bookRepository.findByGoogleBookId(x.getGoogleBookId()) == null) {
                            bookRepository.save(x);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getImagePath(String name) {
        return Paths.get(storagePath, name).toString();
    }

    private List<Book> createBooks(Volumes volumes, HttpServletRequest request) {

        return volumes.getItems().stream()
                .map(x -> {
                    Book book = new Book();
                    book.setGoogleBookId(x.getId());
                    book.setTitle(x.getVolumeInfo().getTitle());
                    book.setDescription(x.getVolumeInfo().getDescription());
                    book.setImage(saveImage(x.getVolumeInfo().getImageLinks().getThumbnail(), request));

                    return book;
                })
                .collect(Collectors.toList());
    }

    private String saveImage(String url, HttpServletRequest request) {

        try {
            String basePath = request.getServletContext().getRealPath("/");
            String fileName = UUID.randomUUID().toString();

            Files.createDirectories(Paths.get(storagePath));
            Files.copy(new URL(url).openStream(), Paths.get(storagePath, fileName));

            return getBaseUrl(request) + relativePath + fileName;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getBaseUrl(HttpServletRequest request) {

        return request.getScheme() + "://" +
                request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}