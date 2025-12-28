CREATE DATABASE 
    DEFAULT CHARACTER SET = 'utf8mb4';
    -- 1. 创建一个叫 day08_db 的数据库
CREATE DATABASE IF NOT EXISTS day08_db;

-- 2. 切换到这个数据库
USE day08_db;

-- 3. 创建一个用户表
CREATE TABLE IF NOT EXISTS Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
SELECT * FROM day08_db.Users;
--1.明确告诉SQL使用这个数据库
USE day08_db;
--1.创建一个班级表
CREATE TABLE IF NOT EXISTS Classes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(50) NOT NULL
    -- teacher_name VARCHAR(50),
    -- created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
--2.往班级表中插入三条数据
INSERT INTO Classes (class_name) VALUES 
('高三一班'),
('高三二班'),
('高三三班');
--3.修改users表，添加一个class_id字段，表示用户所属的班级 增加班级外键
ALTER TABLE Users ADD COLUMN class_id INT;
DESC Users;
USE day08_db;
--4.建立外键约束（确保学生关联的班级必须存在）
ALTER TABLE Users
ADD CONSTRAINT fk_student_class
FOREIGN KEY (class_id) REFERENCES Classes(id);
--5.给现有的学生分配班级
UPDATE Users SET class_id = 1 WHERE id  IS NULL; 
SELECT * FROM Users;
USE day08_db;
UPDATE Users SET class_id = 1 WHERE class_id IS NULL;