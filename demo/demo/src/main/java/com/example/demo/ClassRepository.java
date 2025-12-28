package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 必须是 interface（接口），并且要继承 JpaRepository
// 注意：这里管理的是 Clazz 实体，主键类型是 Long
@Repository
public interface ClassRepository extends JpaRepository<Clazz, Long> {
}