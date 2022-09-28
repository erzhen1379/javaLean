package leaning.jdk.thread;

/**
 * 实现Runnable接口并重写run()方法实现多线程
 */
public class RunnableTest implements Runnable {
    public static void main(String[] args) {
        RunnableTest rTest1 = new RunnableTest();
        Thread thread1 = new Thread(rTest1, "张三");
        Thread thread2 = new Thread(rTest1, "李四");
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " 执行：" + i);
        }
    }
}
