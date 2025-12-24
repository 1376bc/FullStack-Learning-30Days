-- 1. 建立一张叫 Students 的表，规定有两列：名字 和 年龄
CREATE TABLE Students (
    name VARCHAR(50),
    age INT
);

-- 2. 往表里填入数据
INSERT INTO Students (name, age) VALUES ('张三', 20);
INSERT INTO Students (name, age) VALUES ('李四', 22);

-- 3. 把表里所有年龄大于 21 岁的人查出来
SELECT * FROM Students WHERE age > 21;
