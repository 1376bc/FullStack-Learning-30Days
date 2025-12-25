# FullStack-Learning-30Days 🚀
每天一个全栈练习，涵盖 Java, Python, SQL，坚持 30 天。

## 📅 进度追踪
| 天数 | 技术栈 | 任务内容 | 状态 | 代码/笔记链接 |
| :--- | :--- | :--- | :--- | :--- |
| **Day 01-07** | **综合基础** | **Java/Python/SQL 基础与 Web 初探** | ✅ 已通关 | [点击查看](./) |
| **Day 08** | **后端进阶** | **Spring Boot + MySQL 联调实战** | ✅ 已完成 | [后端代码](./demo/) / [脚本](./day01/) |
| Day 09-14 | 后端进阶 | 复杂业务逻辑与 API 设计 | ⏳ 进行中 | |
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
## 📝 第二阶段进阶心得 (2025-12-25)
- **Spring Boot**: 摆脱了原始脚本，开始使用工业级框架。理解了 **Entity(模型)**、**Repository(仓库)**、**Controller(接口)** 的三层架构。
- **JPA/ORM**: 体验了 Java 对象直接映射数据库表的威力，极大简化了 SQL 编写。
- **自动化运维**: 使用 Python 的 `pymysql` 库实现了 **Seed Data(数据初始化)**，学会了用代码代替手动输入。
- **环境搭建**: 成功在本地部署了 **MySQL Server**，并打通了 `Database -> Java -> Browser` 的全链路。

## ⚠️ 避坑指南 (最新补充)

### 6. GitHub 身份验证 (Personal Access Token)
- **坑点**：GitHub 已停止支持密码推送，直接用账号密码 `git push` 会报 `Invalid username or token`。
- **解决**：需在 GitHub Settings 中生成 **PAT (Classic)**，并勾选 `repo` 权限。推送时将 Token 作为密码输入。
- **安全提醒**：**永远不要将 Token 发在公开聊天或代码中！**（若泄露需立即在 GitHub 撤销）。

### 7. Git 嵌套仓库错误
- **坑点**：如果子文件夹里有 `.git` 账本，主仓库会将其识别为 Submodule，导致无法添加文件。
- **解决**：删除子文件夹内的 `.git` 隐藏文件夹，并运行 `git rm -r --cached [文件夹名]` 重置状态。

### 8. Spring Boot 数据库连接
- **坑点**：`application.properties` 配置中，密码错误或时区未设置会导致启动失败。
- **解决**：确保 `serverTimezone=UTC` 并核对本地 MySQL 的 Root 密码。

### 9. 代理网络问题 (Failed to connect to 127.0.0.1)
- **坑点**：开启科学上网工具后，Git 可能会残留代理配置导致无法 Clone 或 Push。
- **解决**：执行 `git config --global --unset http.proxy` 清除 Git 全局代理设置。

保持饥饿，保持聪明。
