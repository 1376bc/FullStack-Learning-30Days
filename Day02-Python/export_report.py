#python自动化脚本
import pandas as pd
from fastapi import FastAPI
from fastapi.responses import FileResponse
from fastapi.middleware.cors import CORSMiddleware
import pymysql
import sqlalchemy as db
app = FastAPI()
#1.配置数据库连接
db_url="mysql+pymysql://root:crbc.1376@127.0.0.1:3306/day08_db"
engine = db.create_engine(db_url)
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_methods=["*"],
    allow_headers=["*"],
)
@app.get("/download-report")
async def download():
    generate_report() # 调用你刚才写好的生成逻辑
    return FileResponse("校长办公室报表_2025.xlsx", filename="学生统计报表.xlsx")

def generate_report():
    print("🚀 正在连接数据库并提取数据...")

    # 2. 执行关联统计查询
    query = """
    SELECT c.class_name as '班级名称', COUNT(u.id) as '学生人数'
    FROM Classes c
    LEFT JOIN Users u ON c.id = u.class_id
    GROUP BY c.class_name
    """

    # 3. 使用 Pandas 读取数据
    df = pd.read_sql(query, engine)

    # 4. 自动生成 Excel
    filename = "校长办公室报表_2025.xlsx"
    df.to_excel(filename, index=False)

    print(f"✅ 报表已生成：{filename}")
    print("--- 报表预览 ---")
    print(df)


if __name__ == "__main__":
    generate_report()