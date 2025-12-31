package com.example.demo;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import java.util.List;
//意思：查询结果存入Redis,名字叫user
@Service // 告诉 Spring，这是一个业务逻辑组件
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
//    private static final Logger log= LoggerFactory.getLogger(UserService.class);
//    public User saveUser(User user){
//        log.info("【业务层】正在保存学生信息: {}",user.getUsername());
//        return userRepository.save(user);
//    }
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClassRepository classRepository;

    // 对应原来的查询逻辑
    @Cacheable(value = "users",key = "(#search == null ? 'all' : #search) + '_' + #pageable.pageNumber")
    public Page<User> getAllUsers(String search, Pageable pageable) {
        log.info("【性能损耗】正在从 MySQL 数据库里苦苦寻找数据...");
        return userRepository.findAll(pageable);
    }

    // 对应获取所有班级
    public List<Clazz> getAllClasses() {
        return classRepository.findAll();
    }

    // 对应保存学生
    public User saveUser(User user) {
        log.info("【业务层】正在保存学生信息: {}", user.getUsername());
        return userRepository.save(user);
    }

    // 对应删除学生
    public void deleteUser(Long id) {
        log.warn("【业务层】危险操作：正在删除 ID 为 {} 的学生", id);
        userRepository.deleteById(id);
    }

    // 对应查找单个学生
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @Transactional
    public User updateUser(long id,User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    if (newUser.getClazz() != null) {
                        user.setClazz(newUser.getClazz());
                    }
                    return userRepository.save(user);
                }).orElse(null);
    }
}