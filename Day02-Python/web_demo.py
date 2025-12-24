from fastapi import FastAPI

app = FastAPI()

@app.get("/")
def home():
    return {"message": "这是你的第一个后端接口！"}

@app.get("/student/{name}")
def get_student(name: str):
    return {"student_name": name, "status": "在校"}
