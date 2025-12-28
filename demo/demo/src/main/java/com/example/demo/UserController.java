package com.example.demo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@CrossOrigin(origins = "*")//解决跨域问题
public class UserController {

    @Autowired
    private ClassRepository classRepository;
    @GetMapping("/classes")
    public List<Clazz> getAllClasses() {
        return classRepository.findAll();
    }
    @Autowired
    private UserRepository userRepository;
// 保留转给个支持分页的方法即可
    @GetMapping("/users") // 访问路径
    public Page<User> getUsers(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size//每页显示多少
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (search != null && !search.isEmpty()) {
            //修改：需要去Repository增加支持分页的搜索方法
            return userRepository.findByUsernameContainingIgnoreCase(search,pageable);
        }
        return userRepository.findAll(pageable);
    }
//    public List<User> getUsers(@RequestParam(required = false) String search) {
//        if(search != null && !search.isEmpty()) {
//            return userRepository.findByUsernameContainingIgnoreCase(search);
//        }
//        return userRepository.findAll(); // 获取数据库中所有用户
//    }

    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user) {
        return userRepository.save(user); // 把前端传来的对象存入数据库
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
    //更新接口：通过ID修改用户信息
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    //关键：在这里加上班级更新的逻辑
                    if(newUser.getClazz() != null) {
                        user.setClazz(newUser.getClazz());
                    }
                    return userRepository.save(user);
                }).orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }
}