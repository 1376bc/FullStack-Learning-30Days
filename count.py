# 1. 这是一个字典（Dictionary），就像真实的字典一样
# 左边是“词条”，右边是“解释”
scores = {
    "张三": 95,
    "李四": 80,
    "王五": 90
}

# 2. 增加一个新的词条
scores["赵六"] = 100

# 3. 打印出所有人的成绩
for name in scores:
    print(name + " 的成绩是: " + str(scores[name]))
