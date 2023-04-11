package leaning.jdk.thread.lock.reentrantLock;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创建两个线程，创建方式可自选；
 * 定义一个全局共享的 static int 变量 count，初始值为 0；
 * 两个线程同时操作 count，每次操作 count 加 1；
 * 每个线程做 100 次 count 的增加操作。
 */
public class ReentrantLockTest implements Runnable {
    private static int count = 0; //定义count = 0
    private static ReentrantLock lock = new ReentrantLock();//创建 lock 实例

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                lock.lock(); //调用 lock 方法
                count++;
                System.out.println(new Date() + " 线程:" + Thread.currentThread().getName() + "  count= " + count);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        Thread t1 = new Thread(reentrantLockTest, "t1");
        Thread t2 = new Thread(reentrantLockTest, "t2");
        t1.start();
        t2.start();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }


}