package com.example.demo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")//解决跨域问题
public class UserController {
    // 定义日志记录器
//    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
//    private ClassRepository classRepository;
// @GetMapping("/users")
    @GetMapping("/classes")
    public List<Clazz> getAllClasses() {
        return userService.getAllClasses();
    }
//    public Page<User> getUsers(@RequestParam(required = false) String name,
//                               @RequestParam (defaultValue = "0")int page,
//                               @RequestParam(defaultValue = "5")int size
//    ) {
//        Pageable pageable = PageRequest.of(page, size);
//        return userService.getAllUsers(name, pageable);
//    }
//    @Autowired
//    private UserRepository userRepository;
// 保留转给个支持分页的方法即可
    @GetMapping("/users") // 访问路径
    public Page<User> getUsers(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size//每页显示多少
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return userService.getAllUsers(search, pageable);
    }
//    public List<User> getUsers(@RequestParam(required = false) String search) {
//        if(search != null && !search.isEmpty()) {
//            return userRepository.findByUsernameContainingIgnoreCase(search);
//        }
//        return userRepository.findAll(); // 获取数据库中所有用户
//    }
@PostMapping("/users/upload")
public Map<String, String> uploadFile(@RequestParam("file") MultipartFile file) {
    Map<String, String> res = new HashMap<>();
    try {
        // 1. 生成一个唯一的文件名（防止名字重复覆盖）
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        // 2. 确定保存路径
        File dest = new File("D:/JuniorSemester/FullStack-Learning-30Days/FullStack-Learning-30Days/uploads/" + fileName);
        // 3. 存文件
        file.transferTo(dest);
        res.put("url", "/FullStack-Learning-30Days/uploads/" + fileName); // 返回给前端的访问路径
        return res;
    } catch (Exception e) {
        res.put("error", "上传失败");
        return res;
    }
}
    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user) {
//        log.info("正在添加新学生: {}", user.getUsername()); // 记录日志
        return userService.saveUser(user); // 把前端传来的对象存入数据库
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
//        log.warn("警告：正在删除 ID 为 {} 的学生记录！", id); // 使用警告级别
        userService.deleteUser(id);
    }
    //更新接口：通过ID修改用户信息
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser) {
        //这里的修改逻辑也可以挪到Service，但是为了演示
//        User user =userService.findById(id);
//        if (user != null) {
//            user.setUsername(newUser.getUsername());
//            user.setEmail(newUser.getEmail());
//            if (newUser.getClazz() != null) user.setClazz(newUser.getClazz());
//            return userService.saveUser(user);
//        }
//        return null;
        return userService.updateUser(id, newUser);
    }

    // uploadFile 方法逻辑较多，可以暂时留在 Controller，或者也挪到 Service。
}

//        return userRepository.findById(id)
//                .map(user -> {
//                    user.setUsername(newUser.getUsername());
//                    user.setEmail(newUser.getEmail());
//                    //关键：在这里加上班级更新的逻辑
//                    if(newUser.getClazz() != null) {
//                        user.setClazz(newUser.getClazz());
//                    }
//                    return userRepository.save(user);
//                }).orElseGet(() -> {
//                    newUser.setId(id);
//                    return userRepository.save(newUser);
//                });
//    }
// }
