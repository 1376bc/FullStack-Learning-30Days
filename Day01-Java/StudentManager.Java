import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    public static void main(String[] args) {
        // 1. 这里的 List 就像是一个班级容器，里面只能放 Student 对象
        List<Student> classroom = new ArrayList<>();

        // 2. 添加学生
        classroom.add(new Student("张三", 85));
        classroom.add(new Student("李四", 92));
        classroom.add(new Student("王五", 78));

        // 3. 逻辑判断：找出 90 分以上的优秀学生
        System.out.println("--- 优秀学生名单 ---");
        for (Student s : classroom) {
            if (s.score >= 90) { // 如果分数大于等于 90
                System.out.println("恭喜 " + s.name + "！你是最棒的。");
            }
        }
    }
}
