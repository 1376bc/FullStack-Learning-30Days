# FullStack-Learning-30Days 🚀
每天一个全栈练习，涵盖 Java, Python, SQL，坚持 30 天。

## 📅 进度追踪
| 天数 | 技术栈 | 任务内容 | 状态 | 代码/笔记链接 |
| :--- | :--- | :--- | :--- | :--- |
| **Day 01-07** | **综合基础** | **Java/Python/SQL 基础与 Web 初探** | ✅ 已通关 | [点击查看](./) |
| Day 08-14 | 后端进阶 | Spring Boot 框架与数据库实战 | ⏳ 待开始 | |
| Day 15-21 | 全栈交互 | 前端基础与前后端联调 | ⏳ 待开始 | |
| Day 22-30 | 综合项目 | 独立完成小型全栈应用 | ⏳ 待开始 | |

## 📝 第一阶段总结 (2025-12-24)
今天以极高的效率完成了第一周的知识铺垫：
- Java: 掌握了 OOP 面向对象、集合框架 (List) 以及多线程 (Thread) 并发。
- Python: 攻克了文件 IO、API 网络请求，并成功运行了 FastAPI 服务器。
- SQL: 熟练使用 DDL/DML，理解了数据库设计的灵魂——JOIN 关联查询。

## ⚠️ 避坑指南 (容易出错的地方)

### 1. Python 编码问题 (UnicodeDecodeError)
- 坑点：Windows 默认 GBK 编码，读取 UTF-8 文件会报错。
- 解决：在 `open()` 函数中必须显式指定 `encoding='utf-8'`。

### 2. 虚拟环境隔离 (.venv)
- 坑点：库装到了全局环境，但 PyCharm 运行的是虚拟环境，导致 `ModuleNotFoundError`。
- 解决：确保使用 `.\.venv\Scripts\python.exe -m pip install` 精准安装到当前项目环境。

### 3. SQL 语句完整性
- 坑点：在写 `JOIN` 查询时，容易漏掉 `FROM` 或 `ON` 子句，导致 `Unknown table` 错误。
- 解决：记住 SQL 执行顺序：先找表 (FROM/JOIN)，再定条件 (ON/WHERE)，最后选字段 (SELECT)。

### 4. FastAPI/Uvicorn 运行路径
- 坑点：在根目录运行子文件夹的代码时，直接写文件名会找不到模块。
- 解决：使用点号路径，如 `uvicorn Day01.web_demo:app --reload`，或者先 `cd` 进入对应目录。

### 5. Java 多线程启动
- 坑点：误用 `thread.run()` 而不是 `thread.start()`。
- 解决：`run()` 只是普通方法调用，只有 `start()` 才会真正开启新线程实现并发。

---
保持饥饿，保持聪明。
