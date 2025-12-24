import requests
def get_web_data():
    # 这是一个免费的测试 API，它会返回一个 JSON 格式的“任务清单”
    url = "https://jsonplaceholder.typicode.com/todos/1"
    
    try:
        response = requests.get(url)
        # 检查状态码，200 代表成功
        if response.status_code == 200:
            data = response.json() # 把返回的乱糟糟的字符串变成 Python 字典
            print(f"任务标题是: {data['title']}")
            print(f"是否已完成: {'是' if data['completed'] else '否'}")
        else:
            print("连接失败")
    except Exception as e:
        print(f"出错了: {e}")

get_web_data()
