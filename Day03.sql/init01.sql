-- 1. 插入数据 (Create)
INSERT INTO Students (name, age, score) VALUES ('赵六', 21, 88);
-- 2. 查询分数在 80 到 100 之间的人 (Read)
SELECT * FROM Students WHERE score BETWEEN 80 AND 100;
-- 3. 修改数据：给张三加 5 分 (Update)
UPDATE Students SET score = score + 5 WHERE name = '张三';
-- 4. 删除不及格的人 (Delete)
DELETE FROM Students WHERE score < 60;
