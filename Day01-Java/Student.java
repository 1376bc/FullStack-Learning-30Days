// 1. 定义模具的名字叫 Student
public class Student {
    String name;  // 名字
    int age;     // 年龄

    // 2. 这是一个“构造函数”，就像是给学生办入学手续，把名字和年龄录入进去
    public Student(String n, int a) {
        name = n;
        age = a;
    }

    // 3. 这是一个“方法”，就是这个学生会做的事：介绍自己
    public void sayHello() {
        System.out.println("你好，我叫 " + name + "，我今年 " + age + " 岁。");
    }

    // 4. 程序的主入口（固定写法，像遥控器的开关）
    public static void main(String[] args) {
        Student s1 = new Student("张三", 20); // 制造一个真实的学号叫 s1 的学生
        s1.sayHello(); // 让这个学生说话
    }
}
