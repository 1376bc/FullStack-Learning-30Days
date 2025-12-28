package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "Users") // 对应数据库里的表名
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "用户名不能为空")
    @Size(min = 2,max = 20,message="名字长度必须在2-20之间")
    private String username;
    @Email(message = "邮箱格式不正确")
    private String email;

    // 必须有无参构造函数（JPA要求）
    public User() {}
    @ManyToOne // 多个学生对应一个班级
    @JoinColumn(name = "class_id") // 对应数据库的外键列
    @JsonIgnoreProperties(
            {"hibernateLazyInitializer","handler"}
    )
    private Clazz clazz;
    // 更新 Getter 和 Setter
    public Clazz getClazz() { return clazz; }
    public void setClazz(Clazz clazz) { this.clazz = clazz; }
    // Getter 和 Setter (在 IDEA 里可以按 Alt+Insert 快速生成)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}