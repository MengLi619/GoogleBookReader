package com.xiaoheifamily.bookstore.repository;

import com.xiaoheifamily.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}
