package com.example.demo;

import jakarta.persistence.*;
import java.util.List;
import java.io.Serializable;

@Entity
@Table(name = "Classes")
public class Clazz  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String className;

    public Clazz() {}
    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
}