# FullStack-Learning-30Days 🚀
每天一个全栈练习，涵盖 Java, Python, SQL，坚持 30 天。

## 📅 进度追踪
| 天数 | 技术栈 | 任务内容 | 状态 | 代码/笔记链接 |
| :--- | :--- | :--- | :--- | :--- |
| **Day 01-07** | **综合基础** | Java/Python/SQL 基础与 Web 初探 | ✅ 已通关 | [查看](./) |
| **Day 08-10** | **后端进阶** | Spring Boot + MySQL + Python 自动化 | ✅ 已通关 | [查看](./demo/) |
| **Day 11-12** | **全栈交互** | CRUD 闭环 + 搜索过滤 + 分页功能 | ✅ 已通关 | [前端](./Day09-Frontend/) |
| **Day 13** | **业务深化** | **多表关联 (OneToMany) 全链路开发** | ✅ 已完成 | [代码汇总](./demo/) |
| Day 14-17 | 安全加固 | 登录系统 (Authentication) 与 权限控制 | ⏳ 待开始 | |
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

## 📝 第三阶段进阶心得 (2025-12-28 更新)
### 1. 数据库建模 (MySQL)
- **外键约束 (Foreign Key)**: 实现了 `Users` (学生) 与 `Classes` (班级) 的 1:N 关联。理解了物理外键对数据一致性的保护。
- **USE 指令**: 深刻记住在执行 DDL 语句前必须显式指定数据库名，避免 `No database selected` 错误。

### 2. 后端关联映射 (JPA)
- **@ManyToOne**: 掌握了 JPA 的关联注解。通过在 Java 对象中嵌入另一个实体对象，实现了 ORM 自动联表。
- **循环引用处理**: 学会了使用 `@JsonIgnoreProperties` 解决双向关联导致的 JSON 无限递归死循环（StackOverflowError）。

### 3. 前端动态渲染 (JS)
- **双重加载逻辑**: 实现了“先加载配置数据（班级列表），再加载业务数据（学生列表）”的顺序逻辑。
- **条件渲染**: 掌握了 JS 模板字符串中的三元运算，优雅处理 `user.clazz` 为空时的显示问题。

## ⚠️ 避坑指南 (多表关联专题)

### 15. SQL: No Database Selected
- **坑点**：在 VS Code 插件中运行 SQL 报“未选择数据库”。
- **解决**：在脚本首行添加 `USE day08_db;` 或右键手动激活数据库。

### 16. API: 404 Not Found (路径微差)
- **坑点**：前端 Fetch 报 404。
- **原因**：后端定义路径为 `/classes` (复数)，前端误写为 `/classe` (单数)。
- **解决**：严格核对 Controller 中的 `@GetMapping` 路径与前端 URL 的拼写及单复数。

### 17. JS: 下拉列表内容重复叠加
- **坑点**：每次刷新数据，班级下拉框的选项就多出一倍。
- **原因**：使用 `innerHTML +=` 时未先清空旧内容。
- **解决**：在循环添加前执行 `select.innerHTML = '<option value="">...</option>';`。

### 18. Java: 堆栈溢出 (JSON Recursive Loop)
- **坑点**：查询学生时 Java 程序突然崩溃报错。
- **原因**：学生类里引用了班级，班级类里又引用了学生，生成 JSON 时互相“死循环”调用。
- **解决**：在多对一属性上使用 `@JsonIgnore` 或指定忽略属性。

---

## 👨‍💻 面试官提问模拟 (Interview Q&A)

**Q1：你在做多表关联时，遇到过 JSON 无限递归问题吗？你是怎么解决的？**
> **A**：遇到过。这是由于双向关联（如学生引用班级，班级又持有学生列表）在序列化为 JSON 时，Jackson 库会不断地互相扫描。我通过在 `@ManyToOne` 字段上添加 `@JsonIgnoreProperties` 忽略掉不必要的级联属性，切断了死循环，从而保证了 JSON 结构的简洁和接口的正常运行。

**Q2：如果数据库里有成千上万个学生，你在前端展示班级名字时会怎么优化性能？**
> **A**：首先，后端必须使用**分页查询（Pageable）**，避免一次性加载所有数据导致 OOM 或前端卡死。其次，在查询关联表时，我会检查 JPA 是否触发了 **N+1 问题**，可以通过 `JOIN FETCH` 语句在一条 SQL 中抓取关联对象，减少数据库查询次数，提升接口响应速度。

**Q3：为什么不直接在学生表里存“班级名称”字符串，而是要搞个班级表存 ID？**
> **A**：这是为了**减少数据冗余**并保证**原子性**。如果存字符串，一旦班级改名，需要修改成千上万条学生记录，且容易产生错别字（如“高三1班”和“高三一班”）。通过 ID 关联，我只需要在班级表改一次，所有关联的学生都会自动同步，这符合数据库设计的第三范式。

---
*保持饥饿，保持聪明。*