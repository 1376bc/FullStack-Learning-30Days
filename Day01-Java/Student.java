public class Student {
    String name; // 属性
    int score;

    public Student(String name, int score) { // 构造函数：初始化对象的“出生证明”
        this.name = name;
        this.score = score;
    }

    public void printInfo() { // 方法：对象能做的事情
        System.out.println(name + " 的分数是: " + score);
    }
}
