import pymysql

# 1. 配置连接信息
config = {
    'host': '127.0.0.1',
    'port': 3306,
    'user': 'root',
    'password': 'crbc.1376',  # <--- 填入老己安装时设的密码
    'database': 'day08_db',
    'charset': 'utf8mb4'
}

try:
    # 2. 连接数据库
    connection = pymysql.connect(**config)
    with connection.cursor() as cursor:
        # 3. 编写插入语句
        sql = "INSERT INTO Users (username, email) VALUES (%s, %s)"

        # 4. 准备 10 条数据
        test_data = [
            (f"student_{i}", f"student_{i}@example.com") for i in range(1, 11)
        ]

        # 5. 批量执行
        cursor.executemany(sql, test_data)

    # 6. 提交事务（重要！不写这个数据进不去硬盘）
    connection.commit()
    print("✅ 成功！10 条测试数据已注入数据库。")

except Exception as e:
    print(f"❌ 出错啦: {e}")
finally:
    if 'connection' in locals():
        connection.close()