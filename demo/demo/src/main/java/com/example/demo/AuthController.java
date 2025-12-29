package com.example.demo;

import com.example.demo.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Admin loginData) {
        Map<String, Object> response = new HashMap<>();

        // 1. 查找用户 去数据库找这个用户
        Optional<Admin> adminOpt = adminRepository.findByUsername(loginData.getUsername());
//2.验证账号是否存在，且密码是否匹配
        if (adminOpt.isPresent() && adminOpt.get().getPassword().equals(loginData.getPassword())) {
            response.put("success", true);
            response.put("message", "登录成功");
            response.put("adminName", adminOpt.get().getUsername());
        } else {
            response.put("success", false);
            response.put("message", "账号或密码错误");
        }
        return response;
    }
}