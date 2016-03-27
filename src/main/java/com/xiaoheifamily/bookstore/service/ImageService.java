package com.xiaoheifamily.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    private final String storagePath;
    private final String relativePath;

    @Autowired
    public ImageService(@Value("${image.storagePath}") String storagePath,
                        @Value("${image.relativePath}") String relativePath) {

        this.storagePath = storagePath;
        this.relativePath = relativePath;
    }

    public String getImagePath(String name) {
        return Paths.get(storagePath, name).toString();
    }

    public String saveImage(String url, String name, HttpServletRequest request) {

        try {
            Files.createDirectories(Paths.get(storagePath));

            Path imagePath = Paths.get(storagePath, name);
            if (!Files.exists(imagePath)) {
                Files.copy(new URL(url).openStream(), Paths.get(storagePath, name));
            }

            return getBaseUrl(request) + relativePath + name;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getBaseUrl(HttpServletRequest request) {

        return request.getScheme() + "://" +
                request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
