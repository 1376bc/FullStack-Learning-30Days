package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    // 关键：根据用户名查找管理员
    Optional<Admin> findByUsername(String username);
}