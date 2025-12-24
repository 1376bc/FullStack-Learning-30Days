public class ThreadDemo {
    public static void main(String[] args) {
        // 1. 创建一个下载任务（分身）
        Thread downloadTask = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("--- 分身：正在下载图片 " + i + " ---");
                try { Thread.sleep(1000); } catch (InterruptedException e) {} // 模拟耗时 1 秒
            }
            System.out.println("--- 分身：下载完成！ ---");
        });

        // 2. 启动分身
        downloadTask.start();

        // 3. 主程序继续运行
        for (int i = 1; i <= 3; i++) {
            System.out.println("主程序：我正在陪用户聊天...");
            try { Thread.sleep(800); } catch (InterruptedException e) {}
        }
    }
}
