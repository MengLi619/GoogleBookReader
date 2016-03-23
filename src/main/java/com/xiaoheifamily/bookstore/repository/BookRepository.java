package com.xiaoheifamily.bookstore.repository;

import com.xiaoheifamily.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByGoogleBookId(String id);
}