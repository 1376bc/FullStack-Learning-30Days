def count_file_words(filename):
    try:
        # 核心改动：加上了 encoding='utf-8'
        with open(filename, 'r', encoding='utf-8') as f:
            content = f.read()
            words = content.split()

        word_map = {}
        for w in words:
            w = w.lower()
            word_map[w] = word_map.get(w, 0) + 1

        print("单词统计结果：", word_map)
    except FileNotFoundError:
        print(f"找不到文件：{filename}，请检查路径。")
    except UnicodeDecodeError:
        print("编码解析失败，请尝试更换 encoding 参数。")

# 运行
count_file_words('test.txt')
