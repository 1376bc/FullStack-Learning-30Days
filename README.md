# FullStack-Learning-30Days 🚀
每天一个全栈练习，涵盖 Java, Python, SQL，坚持 30 天。

## 📅 进度追踪
| 天数 | 技术栈 | 任务内容 | 状态 | 代码/笔记链接 |
| :--- | :--- | :--- | :--- | :--- |
| **Day 01-07** | **综合基础** | Java/Python/SQL 基础与 Web 初探 | ✅ 已通关 | [查看](./) |
| **Day 08-10** | **后端进阶** | Spring Boot + MySQL + Python 自动化 | ✅ 已通关 | [查看](./demo/) |
| **Day 11-12** | **全栈交互** | **CRUD 闭环 + 搜索过滤 + 分页功能** | ✅ 已通关 | [前端](./Day09-Frontend/) |
| Day 13-17 | 业务深化 | 多表关联 (OneToMany) 与 权限安全 | ⏳ 待开始 | |
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
## 📝 阶段性总结 (2025-12-27 更新)
### 1. 后端 (Spring Boot / JPA)
- **RESTful 规范**: 实现了 GET (查), POST (增), PUT (改), DELETE (删) 的标准谓词。
- **动态分页**: 掌握了 `Pageable` 接口，理解了 `Page<T>` 对象与普通 `List<T>` 的区别。
- **模糊查询**: 利用 JPA 命名规范 `findBy...ContainingIgnoreCase` 零 SQL 实现搜索。

### 2. 前端 (HTML / JS / Bootstrap)
- **异步交互**: 熟练使用 `fetch` + `async/await` 抓取后端数据。
- **动态渲染**: 通过 JS 操纵 DOM，将 JSON 对象转化为动态表格。
- **用户体验**: 引入 **SweetAlert2** 替代原生 `alert`，实现工业级的交互反馈。

### 3. 工程化与 Git
- **冲突处理**: 第一次独立处理了 `git pull` 引发的合并冲突，学会了使用 **Vim 编辑器 (`:wq`)**。
- **环境隔离**: 深入理解了前后端端口隔离引发的 **CORS** 跨域难题及解决方案。

## ⚠️ 避坑指南 (最新补充)

### 10. CORS 跨域拦截
- **坑点**：前端 HTML 直接访问后端 8080 会被浏览器拦截。
- **解决**：在 Controller 类上添加 `@CrossOrigin(origins = "*")`。

### 11. 分页数据的 JSON 结构陷阱
- **坑点**：后端改用 `Page` 返回后，前端直接 `data.forEach` 报 `is not a function`。
- **原因**：Page 对象不是数组，其真正的数组存在 `data.content` 中。
- **解决**：前端需访问 `const users = result.content;` 后再进行遍历。

### 12. JS 作用域与 window.onload
- **坑点**：将 `window.onload` 卸载某个 function 内部，导致页面初始化时不加载数据。
- **解决**：确保初始化逻辑在全局作用域下，或正确放置在大括号之外。

### 13. Git 合并冲突与 Vim 退出
- **坑点**：执行 `git pull` 弹出黑色命令窗口，无法打字或退出。
- **解决**：按下 `Esc` 键，输入 `:wq` (保存并退出) 即可完成 Merge。

### 14. 端口占用 (Port 8080 used)
- **坑点**：重启项目报端口占用。
- **解决**：使用 `netstat -ano | findstr :8080` 查 PID，再用 `taskkill /F /PID [ID]` 杀掉旧进程。

---
保持饥饿，保持聪明。
