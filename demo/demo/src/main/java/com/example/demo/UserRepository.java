package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 魔法：只要方法名叫这个，JPA 就会自动生成 SQL: WHERE username LIKE %keyword%
    Page<User> findByUsernameContainingIgnoreCase(String username, Pageable pageable);
}