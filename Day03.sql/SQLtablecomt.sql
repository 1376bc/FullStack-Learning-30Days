-- 1. 用户表
CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    username VARCHAR(50)
);

-- 2. 博客表 (用 user_id 关联)
CREATE TABLE Posts (
    post_id INT PRIMARY KEY,
    title VARCHAR(100),
    author_id INT, 
    FOREIGN KEY (author_id) REFERENCES Users(user_id) -- 这里的 author_id 指向 Users 表
);

-- 3. 关联查询 (最核心的 SQL 技能：JOIN)
-- 任务：查出所有博客的标题，以及对应的作者名字
SELECT Posts.title, Users.username 
FROM Posts
JOIN Users ON Posts.author_id = Users.user_id;
