FullStack-Learning-30Days 🚀
每天一个全栈练习，涵盖 Java, Python, SQL，坚持 30 天。
📅 进度追踪
阶段	天数	技术栈	核心任务内容	状态	代码/笔记链接
第一阶段	Day 01-07	基础综合	Java/Python/SQL 基础语法、多线程并发初探	✅ 已通关	查看
第二阶段	Day 08-10	后端工业化	Spring Boot + MySQL 本地环境、Python 自动化灌数	✅ 已通关	代码
第三阶段	Day 11-15	业务深化	CRUD 闭环、分页搜索、多表关联、登录安全、Python 报表导出	✅ 已通关	前端
第四阶段	Day 16-18	架构升级	文件上传系统、Service 层解耦、Swagger 接口文档、全局异常拦截	✅ 已通关	代码
第五阶段	Day 19	性能优化	Redis 高性能缓存、SQL 索引优化、序列化实战	✅ 已通关	代码
第六阶段	Day 20-30	部署监控	Docker 容器化、服务器上线、系统压力测试	⏳ 进行中	
📝 核心技术心得汇总
1. 工业级架构重构 (Day 17 - 18)
三层架构 (3-Tier Architecture): 实现了从“胖 Controller”到 Controller -> Service -> Repository 的蜕变。Controller 仅处理请求分发，Service 负责核心业务逻辑与事务，Repository 专注数据持久化。
全局异常拦截 (@RestControllerAdvice): 建立了系统的“防弹衣”逻辑，无论后端发生空指针还是数据库异常，均能返回格式统一（Success/Message/Error）的 JSON，大幅提升系统稳定性。
自动化文档 (Swagger): 集成 SpringDoc OpenAPI，实现“代码即文档”，通过 UI 界面直接进行接口测试，彻底告备手动编写 API 手册。
2. 多媒体处理与动静分离 (Day 16)
文件流处理: 使用 MultipartFile 接收二进制数据，配合 UUID 重命名机制解决硬盘文件名冲突。
资源映射机制: 通过 WebMvcConfigurer 将 Web 虚拟路径映射至服务器物理硬盘路径，实现了高效的头像预览功能。
3. 性能巅峰优化 (Day 19 - 跨年突破)
Redis 高性能缓存: 引入 spring-boot-starter-data-redis，实现 Cache-Aside 模式。查询请求优先命中内存（Redis），未命中再穿透至硬盘（MySQL），系统响应速度实现百倍级提升。
SQL 执行计划分析: 针对高频搜索字段建立 INDEX 索引，通过 EXPLAIN 指令验证了从 ALL（全表扫描）到 ref（索引扫描）的质变。
序列化深度应用: 深刻理解了分布式环境下 Java 对象必须实现 Serializable 接口及其 serialVersionUID 的重要性。
⚠️ 避坑指南 (开发者血泪总结)
🔴 Spring Boot & 架构陷阱
Swagger 404 冲突: 手动配置静态资源映射（如上传图片路径）时，会覆盖 Swagger 的默认路径。
解决: 需在配置类中补充 classpath:/META-INF/resources/ 路径映射，并注意 META-INF 的拼写（不是 META-IF）。
注解语法: Java 注解（如 @ExceptionHandler）末尾严禁加分号，否则会导致编译失败且报错信息晦涩。
Bean 注入错误: 在删除 Repository 注入改为 Service 注入时，若留下“孤儿” @Autowired，会导致 Spring 尝试对后续方法的参数（String/int）进行自动装配从而报错。
🟡 Redis & 序列化
序列化崩溃: 开启缓存后报 500 错误，提示 DefaultSerializer requires a Serializable payload。
解决: 被缓存的实体类（User/Clazz）必须 implements Serializable。
缓存脏数据: 修改实体类结构后，Redis 中的旧二进制数据会导致解析失败。
解决: 执行 redis-cli 中的 flushall 命令清空缓存。
🔵 前端逻辑
引号陷阱: JS 模板字符串 ${} 必须配套 反引号 (`)。
单复数偏差: 全栈联调时，后端路径 /upload 与前端 fetch 路径 /uploads 的一字之差会导致 405 Method Not Allowed 错误。
👨‍💻 面试官提问模拟 (Day 16-19 专项)
Q1：为什么把业务逻辑写在 Service 层而不是 Controller？
A：1. 事务管理：Spring 的 @Transactional 通常加在 Service 层，确保多步数据库操作的原子性。2. 代码复用：同一个逻辑（如计算学生平均分）可以被不同的 Controller（Web端、移动端）公用。3. 解耦：方便进行单元测试，不依赖 HTTP 请求环境。
Q2：Redis 缓存虽然快，如何保证它和 MySQL 的数据一致性？
A：目前采用的是失效模式。在执行 save (更新) 或 delete 操作时，使用 @CacheEvict 注解自动清除对应的 Redis Key。下次查询时，系统由于缓存未命中会重新从数据库加载最新数据并写入缓存，从而保证最终一致性。
Q3：你的图片上传功能，为什么不直接把图片存入数据库的 LongBlob 字段？
A：这会导致数据库极其肥大。图片属于大二进制文件，存入数据库会占用大量内存页、导致索引效率下降、备份缓慢。工业界通用的做法是“动静分离”：图片存硬盘（或云存储 OSS），数据库只存图片的 URL 字符串。
Q4：如果查询速度很慢，加了索引也没用，你会怎么排查？
A：我会用 EXPLAIN 查看执行计划。检查是否发生了索引失效，例如：在搜索条件上使用了函数运算、使用了 != 或 NOT IN、或者 LIKE 查询时以 % 开头（左模糊查询）。
---
保持饥饿，保持聪明。